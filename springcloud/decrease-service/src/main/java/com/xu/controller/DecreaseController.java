package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.xu.feign.DecreaseFeign;
import com.xu.model.Result;
import com.xu.service.DecreaseService;

@RestController
public class DecreaseController implements DecreaseFeign{
	
	@Autowired
	private DecreaseService decreaseService;

	@Override
	public Result decrease(Integer uid, String money) {
		int result = 0;
		try {
			result = decreaseService.decrease(uid,money);
		} catch (Exception e) {
			return Result.error(504, e.getMessage());
		}
		if (result>0) {
			return Result.ok();
		} else {
			return Result.error(504, "减钱失败");
		}
	}

}
