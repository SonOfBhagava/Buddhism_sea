package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.ClassSchedule;
import com.bhagava.traineemanage.entity.ClassScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassScheduleMapper {
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