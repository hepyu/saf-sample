package com.future.saf.sample.dubbo.apollo.remote.impl;

import org.apache.dubbo.config.annotation.Service;

import com.future.saf.sample.dubbo.apollo.remote.api.ShopRPC;
import com.future.saf.sample.dubbo.apollo.remote.dto.ShopDTO;
import com.future.saf.sample.dubbo.apollo.remote.dto.TestSameMethodNameDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShopRPCImpl implements ShopRPC {

	@Override
	public ShopDTO getShop(Long shopId) {
		ShopDTO shop = new ShopDTO();
		shop.setId(shopId);
		log.info("{} - {} - {}", this.getClass(), "getShop()", shop);
		return shop;
	}

	@Override
	public TestSameMethodNameDTO testSameMethodName(Long sleepTimestamp) {

		TestSameMethodNameDTO dto = new TestSameMethodNameDTO();
		dto.setSleepTimestamp(sleepTimestamp);

		try {
			Thread.sleep(sleepTimestamp);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return dto;
	}

	@Override
	public TestSameMethodNameDTO testSameMethodName(Long sleepTimestamp, Long multiplier) {

		TestSameMethodNameDTO dto = new TestSameMethodNameDTO();
		dto.setSleepTimestamp(sleepTimestamp * multiplier);

		try {
			Thread.sleep(sleepTimestamp * multiplier);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return dto;
	}

}
