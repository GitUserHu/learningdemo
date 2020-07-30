package demo_20200630;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
	private static ThreadLocal<Map<String, SimpleDateFormat>> sdfMap = new ThreadLocal<Map<String, SimpleDateFormat>>() {
		protected Map<String, SimpleDateFormat> initialValue() {
			//System.out.println(Thread.currentThread().getName() + " init pattern: " + Thread.currentThread());
			return new HashMap<>();
		};
	};

	public static SimpleDateFormat getSdf(final String pattern) {
		Map<String, SimpleDateFormat> tl = sdfMap.get();
		SimpleDateFormat sdf = tl.get(pattern);
		if (sdf == null) {
			//System.out.println(Thread.currentThread().getName() + " put new sdf of pattern " + pattern + " to map");
			sdf = new SimpleDateFormat(pattern);
			tl.put(pattern, sdf);
		}
		return sdf;
	}

	public static Map<String, SimpleDateFormat> getMap(String pattern) {
		Map<String, SimpleDateFormat> tl = sdfMap.get();
		SimpleDateFormat sdf = tl.get(pattern);
		if (sdf == null) {
			//System.out.println(Thread.currentThread().getName() + " put new sdf of pattern " + pattern + " to map");
			sdf = new SimpleDateFormat(pattern);
			tl.put(pattern, sdf);
		}
		return tl;
	}
	
	public static String format(Date date, String pattern) {
		return getSdf(pattern).format(date);
	}

	public static Date parse(String dateStr, String pattern) throws ParseException {
		return getSdf(pattern).parse(dateStr);
	}
	
	public static void remove() {
		sdfMap.remove();
	}

}
