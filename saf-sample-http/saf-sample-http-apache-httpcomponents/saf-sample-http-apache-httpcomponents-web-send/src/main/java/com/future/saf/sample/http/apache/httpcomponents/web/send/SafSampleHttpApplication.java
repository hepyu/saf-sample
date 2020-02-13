package com.future.saf.sample.http.apache.httpcomponents.web.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.future.saf.configcenter.apollo.EnableApolloConfigAutoChangePrint;
import com.future.saf.flowcontrol.sentinel.basic.EnableSentinel;
import com.future.saf.http.apache.httpcomponents.syncimpl.EnableApacheHttpcomponentsBioClient;

/**
 * Created by hepengyuan on 2018/09/27.
 */
@SpringBootApplication
@EnableApolloConfig(value = { "application", "saf.log.level", "sentinel.demo-web-send" })
@EnableApolloConfigAutoChangePrint

@EnableApacheHttpcomponentsBioClient(beanNamePrefix = "internet", instance = "internet", project = "demo-web-send")
@EnableApacheHttpcomponentsBioClient(beanNamePrefix = "demoWebReceive", instance = "demo-web-receive", project = "demo-web-send")

@EnableSentinel
public class SafSampleHttpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafSampleHttpApplication.class, args);
	}

}
