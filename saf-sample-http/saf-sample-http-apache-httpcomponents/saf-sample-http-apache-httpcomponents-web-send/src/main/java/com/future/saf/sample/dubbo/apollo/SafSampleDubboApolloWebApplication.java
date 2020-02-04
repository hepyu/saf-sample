package com.future.saf.sample.dubbo.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.future.saf.configcenter.apollo.EnableApolloConfigAutoChangePrint;
import com.future.saf.http.apache.httpcomponents.syncimpl.EnableHttpBioClient;

/**
 * Created by hepengyuan on 2018/09/27.
 */
@SpringBootApplication
@EnableApolloConfig(value = { "application", "saf.log.level" })
@EnableApolloConfigAutoChangePrint

@EnableHttpBioClient(beanNamePrefix = "internet", instance = "internet")
@EnableHttpBioClient(beanNamePrefix = "demoWebReceive", instance = "demo-web-receive")
public class SafSampleDubboApolloWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafSampleDubboApolloWebApplication.class, args);
	}

}
