package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xu.model.Result;
import com.xu.service.TradeService;

@RestController
public class TradeController {
	
	@Autowired
	private TradeService  tradeService;
	
	@GetMapping("/trade")
	public Result trade() {
		int result = 0;
		try {
			result = tradeService.trade();
		} catch (Exception e) {
			return Result.error(500, "失败"+e.getMessage());
		}
		if (result > 0) {
			return Result.ok();
		}else {
			return Result.error();
		}
	}

}
