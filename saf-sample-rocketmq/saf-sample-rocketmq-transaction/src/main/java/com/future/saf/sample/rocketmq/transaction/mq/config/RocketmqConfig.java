package com.future.saf.sample.rocketmq.transaction.mq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Configuration
@PropertySource("classpath:application.yml") // 读取application.yml文件
@Getter
public class RocketmqConfig {

	@Value("${rocketmq.producer.group}")
	private String producerGroup;

	@Value("${rocketmq.name-server}")
	private String nameServer;

	@Value("${rocketmq.producer.send-msg-timeout}")
	private int sendMsgTimeout;
}
