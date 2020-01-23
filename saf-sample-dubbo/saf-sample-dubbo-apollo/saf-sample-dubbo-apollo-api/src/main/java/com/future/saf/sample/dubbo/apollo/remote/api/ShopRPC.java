package com.future.saf.sample.dubbo.apollo.remote.api;

import com.future.saf.sample.dubbo.apollo.remote.dto.ShopDTO;

public interface ShopRPC {

	/**
	 * 获取店铺基本信息
	 * 
	 * @param shopId
	 * @return
	 */
	public ShopDTO getShop(Long shopId);
}
