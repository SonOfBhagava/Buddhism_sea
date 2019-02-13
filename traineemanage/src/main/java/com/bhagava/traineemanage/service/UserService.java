package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/28 15:59
 * @Description:
 */

public interface UserService {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertList(List<User> list);

    List<Integer> selectGrroup(Integer ClassId);
}
