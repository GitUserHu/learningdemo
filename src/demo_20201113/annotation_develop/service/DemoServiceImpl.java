package demo_20201113.annotation_develop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo_20201113.annotation_develop.dao.AccountDAO;
import demo_20201113.annotation_develop.entity.Account;


@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	AccountDAO accountDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void register(Account account) {
		account.setUserName("added in tx-B");
		
		accountDao.save(account);
		
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Account account) {
		account.setUserName("added in tx-C");
		accountDao.save(account);
		
	}

}
