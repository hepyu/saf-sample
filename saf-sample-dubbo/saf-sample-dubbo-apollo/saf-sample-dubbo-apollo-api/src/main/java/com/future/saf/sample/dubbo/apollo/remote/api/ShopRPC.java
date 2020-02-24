package com.future.saf.sample.dubbo.apollo.remote.api;

import com.future.saf.sample.dubbo.apollo.remote.dto.ShopDTO;
import com.future.saf.sample.dubbo.apollo.remote.dto.TestSameMethodNameDTO;

public interface ShopRPC {

	/**
	 * 获取店铺基本信息
	 * 
	 * @param shopId
	 * @return
	 */
	public ShopDTO getShop(Long shopId);

	public TestSameMethodNameDTO testSameMethodName(Long sleepTimestamp);

	public TestSameMethodNameDTO testSameMethodName(Long sleepTimestamp, Long multiplier);

}
