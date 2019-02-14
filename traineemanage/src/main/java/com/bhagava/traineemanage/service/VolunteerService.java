package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.Volunteer;
import com.bhagava.traineemanage.entity.VolunteerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public interface VolunteerService {
    long countByExample(VolunteerExample example);

    int deleteByExample(VolunteerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Volunteer record);

    int insertSelective(Volunteer record);

    List<Volunteer> selectByExample(VolunteerExample example);

    Volunteer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Volunteer record, @Param("example") VolunteerExample example);

    int updateByExample(@Param("record") Volunteer record, @Param("example") VolunteerExample example);

    int updateByPrimaryKeySelective(Volunteer record);

    int updateByPrimaryKey(Volunteer record);
}
