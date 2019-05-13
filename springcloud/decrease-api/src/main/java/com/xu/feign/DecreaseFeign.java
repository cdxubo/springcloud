package com.xu.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xu.feign.fallback.DecreaseFallback;
import com.xu.model.Result;

@FeignClient(name="decrease-service",fallback=DecreaseFallback.class)
public interface DecreaseFeign {

	@PostMapping("/decrease")
	Result decrease(@RequestParam(value="uid")Integer uid,@RequestParam(value="money")String money);
}
