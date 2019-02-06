package com.bhagava.traineemanage.service;

import com.bhagava.common.service.BaseService;
import com.bhagava.traineemanage.entity.ClassSchedule;
import com.bhagava.traineemanage.entity.ClassScheduleExample;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public interface ClassScheduleService{
    long countByExample(ClassScheduleExample example);

    int deleteByExample(ClassScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassSchedule record);

    int insertSelective(ClassSchedule record);

    List<ClassSchedule> selectByExample(ClassScheduleExample example);

    ClassSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassSchedule record, @Param("example") ClassScheduleExample example);

    int updateByExample(@Param("record") ClassSchedule record, @Param("example") ClassScheduleExample example);

    int updateByPrimaryKeySelective(ClassSchedule record);

    int updateByPrimaryKey(ClassSchedule record);
}
