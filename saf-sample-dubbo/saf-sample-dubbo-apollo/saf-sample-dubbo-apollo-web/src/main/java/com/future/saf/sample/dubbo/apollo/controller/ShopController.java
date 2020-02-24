package com.future.saf.sample.dubbo.apollo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.future.saf.core.web.WebResult;
import com.future.saf.sample.dubbo.apollo.remote.api.ShopRPC;
import com.future.saf.sample.dubbo.apollo.remote.dto.ShopDTO;
import com.future.saf.sample.dubbo.apollo.remote.dto.TestSameMethodNameDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/shop")
public class ShopController {

	@Reference
	private ShopRPC shoprpc;

	@RequestMapping("/getShop")
	public WebResult<ShopDTO> getShop(@RequestParam(name = "shopId") Long shopId) {
		try {
			ShopDTO shopDTO = shoprpc.getShop(shopId);
			return new WebResult<>(WebResult.CODE_SUCCESS, "getShop success.", shopDTO);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping("/testSameMethodName")
	public WebResult<TestSameMethodNameDTO> testSameMethodName(
			@RequestParam(name = "sleepTimestamp") Long sleepTimestamp) {
		try {
			TestSameMethodNameDTO dto = shoprpc.testSameMethodName(sleepTimestamp);
			return new WebResult<>(WebResult.CODE_SUCCESS, "testSameMethodName success.", dto);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping("/testSameMethodName/multiplier")
	public WebResult<TestSameMethodNameDTO> testSameMethodName(
			@RequestParam(name = "sleepTimestamp") Long sleepTimestamp,
			@RequestParam(name = "multiplier") Long multiplier) {
		try {
			TestSameMethodNameDTO dto = shoprpc.testSameMethodName(sleepTimestamp, multiplier);
			return new WebResult<>(WebResult.CODE_SUCCESS, "testSameMethodName/multiplier success.", dto);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
}
