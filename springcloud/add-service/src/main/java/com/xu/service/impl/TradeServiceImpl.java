package com.xu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.tx.annotation.TxTransaction;
import com.xu.domain.Account;
import com.xu.domain.AccountExample;
import com.xu.feign.DecreaseFeign;
import com.xu.mapper.AccountMapper;
import com.xu.model.Result;
import com.xu.service.TradeService;

/**
 * 转账
 * @author Administrator
 *
 */
@Service
public class TradeServiceImpl implements TradeService{
	
	@Autowired
	private AccountMapper mapper;
	
	@Autowired
	private DecreaseFeign decrease;

	@TxTransaction(isStart=true)  //分布式事务开始的点
	@Transactional
	public int trade() {
		int decUid = 1;
		int addUid = 2;
		String money = "200";
		// 减钱 ——远程调用
		Result decreaseResult = decrease.decrease(decUid, money);
		if (decreaseResult.getStatus()!=200) {
			return 0;
		}
		// 加钱——本地调用
		AccountExample accountExample = new AccountExample();
		accountExample.createCriteria().andUidEqualTo(addUid);
		List<Account> accounts = mapper.selectByExample(accountExample);
		if (accounts==null||accounts.isEmpty()||accounts.size()>1) {
			throw new RuntimeException("用户不存在或数据库错误");
		}
		Account account = accounts.get(0);
		Double total = Double.valueOf(account.getMoney())+Double.valueOf(money);
		account.setMoney(total+"");	
		int result = mapper.updateByPrimaryKey(account);
		int i = 10/0; // 模拟出现异常的情况
		return result;
	}

}
