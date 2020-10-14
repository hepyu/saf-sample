package com.future.saf.sample.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.future.saf.sample.rocketmq.biz.TransactionMsgProducer;

@SpringBootApplication
public class RocketmqTransactionProducerApplication {

	public static void main(String[] args) {
		System.out.println("000000000");
		ApplicationContext context = SpringApplication.run(RocketmqTransactionProducerApplication.class, args);
//		TransactionMsgProducer producer = context.getBean(TransactionMsgProducer.class);
//		System.out.println(producer);
		System.out.println(111111111);
	}

}