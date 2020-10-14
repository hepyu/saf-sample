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

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TransactionListenerImpl implements TransactionListener {

	@Override
	public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
		LocalTransactionState state = LocalTransactionState.UNKNOW;
		try {
			boolean isCommit = doTransfer();
			if (isCommit) {
				state = LocalTransactionState.COMMIT_MESSAGE;
			} else {
				state = LocalTransactionState.ROLLBACK_MESSAGE;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return state;
	}

	@Override
	public LocalTransactionState checkLocalTransaction(MessageExt msg) {
		LocalTransactionState state = LocalTransactionState.UNKNOW;
		try {
			boolean isCommit = checkTransferStatus();
			if (isCommit) {
				state = LocalTransactionState.COMMIT_MESSAGE;
			} else {
				state = LocalTransactionState.ROLLBACK_MESSAGE;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return state;
	}

	private boolean doTransfer() {
		// TODO 转账
		return true;
	}

	private boolean checkTransferStatus() {
		// TODO check
		return true;
	}
}
