package com.future.saf.sample.rocketmq.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TransferRecord implements Serializable {

	private static final long serialVersionUID = -815460992542541866L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 转账人id
	 */
	private Long fromUserId;

	/**
	 * 转账金额
	 */
	private Long changeMoney;

	/**
	 * 消息事务id
	 */
	private String transactionId;

	/**
	 * 被转账人id
	 */
	private Long toUserId;

	/**
	 * 转账流水编号
	 */
	private String recordNo;

}
