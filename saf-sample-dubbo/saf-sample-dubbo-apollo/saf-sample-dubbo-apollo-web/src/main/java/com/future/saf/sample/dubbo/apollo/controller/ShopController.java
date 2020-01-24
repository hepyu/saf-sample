package com.future.saf.sample.dubbo.apollo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.future.saf.core.web.WebResult;
import com.future.saf.sample.dubbo.apollo.remote.api.ShopRPC;
import com.future.saf.sample.dubbo.apollo.remote.dto.ShopDTO;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

	@Reference
	private ShopRPC shoprpc;

	@RequestMapping("/getShop")
	public WebResult<ShopDTO> getShop(@RequestParam(name = "shopId") Long shopId) {
		ShopDTO shopDTO = shoprpc.getShop(shopId);
		return new WebResult<>(WebResult.CODE_SUCCESS, "getShop success.", shopDTO);
	}

}
