package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
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

    // 获取当前的组
    @Select("SELECT `group` from `user` where class_id = #{id} GROUP BY `group`")
    List<Integer> selectGroup(Integer id);
}