package demo_20201106.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo_20201106.transaction.dao.AccountDAO;
import demo_20201106.transaction.entity.Account;


@Service
public class TestServiceImpl implements TestService {
	@Autowired
	AccountDAO accountDao;
	@Autowired
	DemoService demoService;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(Account account) throws Exception {
		
		account.setUserName("added in tx-A");
		accountDao.save(account);
		demoService.register(account);
		demoService.insert(account);
		throw new RuntimeException();
		
	}


	
	


}
