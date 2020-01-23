package com.future.saf.sample.dubbo.apollo.remote.impl;

import org.apache.dubbo.config.annotation.Service;

import com.future.saf.sample.dubbo.apollo.remote.api.ShopRPC;
import com.future.saf.sample.dubbo.apollo.remote.dto.ShopDTO;

import lombok.extern.slf4j.Slf4j;

//@MotanService(basicService = "mallBasicServiceConfigBean")
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

}
