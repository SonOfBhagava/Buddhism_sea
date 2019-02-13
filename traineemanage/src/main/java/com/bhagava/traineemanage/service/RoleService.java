package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.Role;
import com.bhagava.traineemanage.entity.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public interface RoleService {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
