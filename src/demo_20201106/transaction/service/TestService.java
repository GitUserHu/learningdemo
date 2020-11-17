package demo_20201106.transaction.service;

import org.springframework.stereotype.Service;

import demo_20201106.transaction.entity.Account;

public interface TestService {
	void save(Account account) throws Exception;
	
}
