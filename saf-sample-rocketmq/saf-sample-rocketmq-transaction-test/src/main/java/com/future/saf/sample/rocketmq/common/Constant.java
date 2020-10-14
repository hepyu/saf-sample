package com.future.saf.sample.rocketmq.common;

public class Constant {

	/**
	 * 项目基础包名称，根据自己公司的项目修改
	 */
	public static final String BASE_PACKAGE = "com.future.saf.sample.rocketmq";
	/**
	 * 业务包名
	 */
	public static final String BIZ_PACKAGE = BASE_PACKAGE + ".biz";

	/**
	 * entity实体包路径
	 */
	public static final String ENTITY_PACKAGE = BIZ_PACKAGE + ".entity";

	public static final String TransactionTopic = "TransanctionMessage";

	public static final String Rocketmq_Namesrv = "127.0.0.1:9876";
}
