package com.future.saf.sample.http.apache.httpcomponents.web.send.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.future.saf.core.web.WebResult;
import com.future.saf.http.apache.httpcomponents.syncimpl.ApacheHttpcomponentsBioClient;
import com.future.saf.sample.http.apache.httpcomponents.web.send.dto.ShopDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/shop")
public class ShopController {

	@Resource(name = "internetApacheHttpcomponentsBioClient")
	private ApacheHttpcomponentsBioClient internetHttpBioClient;

	@Resource(name = "demoWebReceiveApacheHttpcomponentsBioClient")
	private ApacheHttpcomponentsBioClient demoWebReceiveHttpBioClient;

	@RequestMapping("/getShop")
	public WebResult<ShopDTO> getShop(@RequestParam(name = "shopId") Long shopId) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shopId);

		HttpUriRequest request = new HttpGet("http://www.baidu.com");
		try {
			HttpResponse response = internetHttpBioClient.execute(UUID.randomUUID().toString(), request, 10,
					TimeUnit.SECONDS);
			// 通过返回对象获取返回数据
			HttpEntity entity = response.getEntity();
			// 通过EntityUtils中的toString方法将结果转换为字符串
			String result = EntityUtils.toString(entity);
			shopDTO.setBaiduResult(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		request = new HttpGet("http://saf-sample-http-apache-httpcomponents-web-receive-prod/user/getUser?userId=100");
		// request = new
		// HttpGet("http://localhost:7010/user/getUser?userId=100");
		try {
			HttpResponse response = demoWebReceiveHttpBioClient.execute(UUID.randomUUID().toString(), request, 10,
					TimeUnit.SECONDS);
			// 通过返回对象获取返回数据
			HttpEntity entity = response.getEntity();
			// 通过EntityUtils中的toString方法将结果转换为字符串
			String result = EntityUtils.toString(entity);
			shopDTO.setUserInfo(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return new WebResult<>(WebResult.CODE_SUCCESS, "getShop success.", shopDTO);
	}

}
