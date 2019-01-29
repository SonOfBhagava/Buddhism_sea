package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserMapper继承基类
 */
@Mapper
public interface UserMapper extends MyBatisBaseDao<User, Integer> {
}