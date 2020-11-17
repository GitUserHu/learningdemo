package demo_20201104.mybatis.dao;

import demo_20201104.mybatis.entity.Account;

public interface AccountDAO {

	void save(Account account);
	
	Account findAccountById();
}
