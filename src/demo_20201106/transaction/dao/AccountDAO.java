package demo_20201106.transaction.dao;

import org.springframework.stereotype.Repository;

import demo_20201106.transaction.entity.Account;

@Repository
public interface AccountDAO {

	void save(Account account);
	
	Account findAccountById();
}
