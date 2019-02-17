package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.VolunteerValidDateExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */

public interface VolunteerValidDateService {
    long countByExample(VolunteerValidDateExample example);

    int deleteByExample(VolunteerValidDateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(com.bhagava.traineemanage.entity.VolunteerValidDate record);

    int insertSelective(com.bhagava.traineemanage.entity.VolunteerValidDate record);

    List<com.bhagava.traineemanage.entity.VolunteerValidDate> selectByExample(VolunteerValidDateExample example);

    com.bhagava.traineemanage.entity.VolunteerValidDate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") com.bhagava.traineemanage.entity.VolunteerValidDate record, @Param("example") VolunteerValidDateExample example);

    int updateByExample(@Param("record") com.bhagava.traineemanage.entity.VolunteerValidDate record, @Param("example") VolunteerValidDateExample example);

    int updateByPrimaryKeySelective(com.bhagava.traineemanage.entity.VolunteerValidDate record);

    int updateByPrimaryKey(com.bhagava.traineemanage.entity.VolunteerValidDate record);
}
