package demo_20201104.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import demo_20201104.mybatis.dao.AccountDAO;
import demo_20201104.mybatis.entity.Account;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println("1");
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		AccountDAO accountDAO = session.getMapper(AccountDAO.class);
		Account account = new Account();
		account.setUserName("test");
		accountDAO.save(account);
		session.commit();
		

	}

}
