package com.future.saf.sample.http.apache.httpcomponents.web.receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.future.saf.configcenter.apollo.EnableApolloConfigAutoChangePrint;

@SpringBootApplication

// 开启apollo配置中心
@EnableApolloConfig(value = { "application", "saf.log.level" })
// 系统启动时会打印@EnableApolloConfig中指定的namespace的初始化值；并且如果运行时会打印发生变化的配置。
@EnableApolloConfigAutoChangePrint

public class SafSampleHttpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafSampleHttpApplication.class, args);
	}

}
