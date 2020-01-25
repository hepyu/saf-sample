package com.future.saf.sample.dubbo.apollo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.future.saf.configcenter.apollo.EnableApolloConfigAutoChangePrint;
import com.future.saf.rpc.dubbo.EnableSafDubbo;

/**
 * Created by hepengyuan on 2018/09/27.
 */
@SpringBootApplication
@EnableApolloConfig(value = { "application", "saf.log.level" })
@EnableApolloConfigAutoChangePrint
@EnableDubbo(scanBasePackages = "com.future.saf.sample.dubbo.apollo")

@EnableSafDubbo(beanNamePrefix = "shoprpc", instance = "shoprpc", project = "saf-sample-dubbo-apollo-web")
public class SafSampleDubboApolloWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafSampleDubboApolloWebApplication.class, args);
	}

}
