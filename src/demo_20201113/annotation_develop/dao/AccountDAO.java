package demo_20201113.annotation_develop.dao;

import org.springframework.stereotype.Repository;

import demo_20201113.annotation_develop.entity.Account;


@Repository
public interface AccountDAO {

	void save(Account account);
	
	Account findAccountById();
}
