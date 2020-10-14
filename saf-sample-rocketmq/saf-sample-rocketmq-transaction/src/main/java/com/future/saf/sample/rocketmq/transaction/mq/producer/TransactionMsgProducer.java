/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.future.saf.sample.rocketmq.transaction.mq.producer;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.future.saf.sample.rocketmq.transaction.common.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TransactionMsgProducer implements InitializingBean {
	private static TransactionMQProducer producer = new TransactionMQProducer("please_rename_unique_group_name");

	@Resource
	private TransactionListenerImpl transactionListener;

	@Override
	public void afterPropertiesSet() throws Exception {
		producer.setNamesrvAddr(Constant.Rocketmq_Namesrv);
		// 设置大点，资源有限，慢。
		producer.setSendMsgTimeout(10 * 10000);

		ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
					@Override
					public Thread newThread(Runnable r) {
						Thread thread = new Thread(r);
						thread.setName("client-transaction-msg-check-thread");
						return thread;
					}
				});

		producer.setExecutorService(executorService);
		// 设置回调检查监听器
		producer.setTransactionListener(transactionListener);
		try {
			producer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}

		new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					// 单次转账唯一编号
					String businessNo = UUID.randomUUID().toString();

					try {
						Message msg = new Message(Constant.TransactionTopic, null, businessNo,
								businessNo.getBytes(RemotingHelper.DEFAULT_CHARSET));
						StringBuilder sb = new StringBuilder();
						String printStr = sb.append("Message::topic:").append(msg.getTopic()).append(",transactionId:")
								.append(msg.getTransactionId()).append(",businessNo:").append(businessNo).toString();
						log.info(printStr);

						SendResult sendResult = producer.sendMessageInTransaction(msg, null);
						printStr = sb.append("SendResult::msgId:").append(sendResult.getMsgId())
								.append(",transactionId:").append(sendResult.getTransactionId())
								.append(",prepare事务消息发送结果:").append(sendResult.getSendStatus()).toString();
						log.info(printStr);
//						System.out.println(":" + sendResult.getSendStatus());
						log.info("");
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}

					try {
						Thread.sleep(1000l);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}

			}
		}).start();
	}

}
