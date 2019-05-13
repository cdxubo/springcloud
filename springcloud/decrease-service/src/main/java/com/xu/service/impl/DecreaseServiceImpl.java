package com.xu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.tx.annotation.TxTransaction;
import com.xu.domain.Account;
import com.xu.domain.AccountExample;
import com.xu.mapper.AccountMapper;
import com.xu.service.DecreaseService;

@Service
public class DecreaseServiceImpl implements DecreaseService{

	@Autowired
	private AccountMapper mapper;
	
	
	@TxTransaction
	@Transactional
	public int decrease(Integer uid, String money) {
		AccountExample accountExample = new AccountExample();
		accountExample.createCriteria().andUidEqualTo(uid);
		List<Account> accounts = mapper.selectByExample(accountExample);
		if (accounts==null||accounts.isEmpty()||accounts.size()>1) {
			throw new RuntimeException("该用户不存在或数据库错误");
		}
		Account account = accounts.get(0);
		Double realMoney = Double.valueOf(account.getMoney());
		Double tradeMoney = Double.valueOf(money);
		if (realMoney<tradeMoney) {
			throw new RuntimeException("余额不足,无法转账");
		}
		account.setMoney(realMoney-tradeMoney+"");
		return mapper.updateByPrimaryKey(account);
	}

}
