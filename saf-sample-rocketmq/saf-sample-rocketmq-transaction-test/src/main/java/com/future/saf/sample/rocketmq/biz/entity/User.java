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
public class User implements Serializable {

	private static final long serialVersionUID = -7908330483392681179L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 余额
	 */
	private Long money;

}
