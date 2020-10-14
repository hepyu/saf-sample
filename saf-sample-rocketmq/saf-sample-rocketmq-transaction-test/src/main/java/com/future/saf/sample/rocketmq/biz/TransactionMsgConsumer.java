package com.future.saf.sample.rocketmq.biz;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import com.future.saf.sample.rocketmq.common.Constant;

public class TransactionMsgConsumer {

	public static void main(String[] args) throws InterruptedException, MQClientException {

		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name_4");

		consumer.setNamesrvAddr(Constant.Rocketmq_Namesrv);

		// consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		consumer.subscribe(Constant.TransactionTopic, "*");

		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
				for (MessageExt msg : msgs) {
					System.out.println("收到消息," + new String(msg.getBody()));
					// Todo 执行加钱操作，比较简单，不写了，也是一个事务，同时要处理幂等。
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		consumer.start();

		System.out.printf("Consumer Started.%n");
	}
}
