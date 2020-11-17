package demo_20201105.springmybatis.dao;

import demo_20201105.springmybatis.entity.Account;

public interface AccountDAO {

	void save(Account account);
	
	Account findAccountById();
}
