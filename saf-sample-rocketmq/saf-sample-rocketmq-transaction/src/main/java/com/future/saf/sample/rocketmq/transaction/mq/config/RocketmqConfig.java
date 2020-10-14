package com.future.saf.sample.rocketmq.transaction.mq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@PropertySource("classpath:application.yml") // 读取application.yml文件
public class RocketmqConfig {

	@Value("${rocketmq.producer.group}")
	private String producerGroup;

	@Value("${rocketmq.producer.name-server}")
	private String nameServer;

	@Value("${rocketmq.producer.send-msg-timeout}")
	private int sendMsgTimeout;
}
