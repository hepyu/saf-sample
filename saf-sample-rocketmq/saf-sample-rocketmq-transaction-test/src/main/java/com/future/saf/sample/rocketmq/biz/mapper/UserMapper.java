package com.future.saf.sample.rocketmq.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.future.saf.sample.rocketmq.biz.entity.User;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

	public int reduceMoney(@Param("userId") Long userId, @Param("money") Long money);

}
