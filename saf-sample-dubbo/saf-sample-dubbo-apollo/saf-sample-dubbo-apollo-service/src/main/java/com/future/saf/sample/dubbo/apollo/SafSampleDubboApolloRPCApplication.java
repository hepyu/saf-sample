package com.future.saf.sample.dubbo.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.future.saf.configcenter.apollo.EnableApolloConfigAutoChangePrint;
import com.future.saf.rpc.dubbo.EnableSafDubbo;

@SpringBootApplication

@EnableSafDubbo(beanNamePrefix = "shop", instance = "shop", project = "saf-sample-dubbo-apollo")
// 开启apollo配置中心
@EnableApolloConfig(value = { "saf.log.level" })
// 系统启动时会打印@EnableApolloConfig中指定的namespace的初始化值；并且如果运行时会打印发生变化的配置。
@EnableApolloConfigAutoChangePrint

public class SafSampleDubboApolloRPCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafSampleDubboApolloRPCApplication.class, args);
	}

}
