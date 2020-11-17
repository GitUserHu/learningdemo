package demo_20201113.annotation_develop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo_20201113.annotation_develop.dao.AccountDAO;
import demo_20201113.annotation_develop.entity.Account;



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
	
		
	}


	
	


}
