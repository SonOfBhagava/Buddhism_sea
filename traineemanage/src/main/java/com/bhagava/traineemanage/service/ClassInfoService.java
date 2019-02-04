package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.ClassInfo;
import com.bhagava.traineemanage.entity.ClassInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public interface ClassInfoService {

    long countByExample(ClassInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    List<ClassInfo> selectByExample(ClassInfoExample example);

    ClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}
