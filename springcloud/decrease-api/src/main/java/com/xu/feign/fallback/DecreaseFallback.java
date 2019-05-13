package com.xu.feign.fallback;

import org.springframework.stereotype.Component;

import com.xu.feign.DecreaseFeign;
import com.xu.model.Result;


@Component
public class DecreaseFallback implements DecreaseFeign{

	@Override
	public Result decrease(Integer uid, String money) {
		return Result.error(505, "DecreaseService已经挂掉了,我执行了断路模式");
		
	}

	
}
