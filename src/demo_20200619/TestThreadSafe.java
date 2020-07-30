package demo_20200619;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 为什么说SimpleDateFormat是线程不安全？
 * SimpleDateFormat将中间结果存储在实例字段中。因此，如果两个线程使用一个实例，则它们可能会使彼此的结果混乱。
	查看源代码可以发现存在一个Calendar实例字段，该字段由DateFormat / SimpleDateFormat上的操作使用。
	例如，parse（..）首先调用calendar.clear（），然后再调用calendar.add（..）。
	如果另一个线程在第一次调用完成之前调用parse（..），它将清除日历，但另一个调用将期望它使用计算的中间结果进行填充。
 * @author jiabing
 *
 */
public class TestThreadSafe {
	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final int COUNT = 10;
	public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat(PATTERN);
	public static final ThreadPoolExecutor THREADPOOL = new ThreadPoolExecutor(COUNT, COUNT, 1000L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>());
	public static final List<String> DATETIME_STRLIST = new ArrayList<>(COUNT);
	public static final ThreadLocal<DateFormat> THREAD_LOCAL = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat(PATTERN);
		};
	};
	static {
		DATETIME_STRLIST.add("2018-04-01 10:00:01");
		DATETIME_STRLIST.add("2018-04-02 10:00:01");
		DATETIME_STRLIST.add("2018-04-03 10:00:01");
		DATETIME_STRLIST.add("2018-04-04 10:00:01");
		DATETIME_STRLIST.add("2018-04-05 10:00:01");
		DATETIME_STRLIST.add("2018-04-06 10:00:01");
		DATETIME_STRLIST.add("2018-04-07 10:00:01");
		DATETIME_STRLIST.add("2018-04-08 10:00:01");
		DATETIME_STRLIST.add("2018-04-09 10:00:01");
		DATETIME_STRLIST.add("2018-04-10 10:00:01");
	}
	public static void main(String[] args) {
		
			
		
		for (String dateTimeStr : DATETIME_STRLIST) {
			THREADPOOL.execute(()->{
		
					try {
						//System.out.println(DateTimeFormatter.ofPattern(PATTERN).parse(dateTimeStr));
						System.out.println(THREAD_LOCAL.get().parse(dateTimeStr));
						//DATEFORMAT.parse(dateTimeStr);
						//System.out.println(parse(dateTimeStr));
						
					
					} catch (ParseException e) {
						
						e.printStackTrace();
					} finally {
						// ，必须回收自定义的ThreadLocal变量，尤其在线程池场景下，线程经常会被复用，如果不清理自定义的 ThreadLocal变量，可能会影响后续业务逻辑和造成内存泄露等问题。
						THREAD_LOCAL.remove();
					}
				
			});
		}
		THREADPOOL.shutdown();
		
		
	}
	/**
	 *     同步调用或者加锁
	 * @param dateTimeStr
	 * @return
	 * @throws ParseException
	 */
	public static synchronized Date parse(String dateTimeStr) throws ParseException {
		return DATEFORMAT.parse(dateTimeStr);
	}

}
