package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.AttendanceRecord;
import com.bhagava.traineemanage.entity.AttendanceRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public interface AttendanceRecordService {
    long countByExample(AttendanceRecordExample example);

    int deleteByExample(AttendanceRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceRecord record);

    int insertSelective(AttendanceRecord record);

    List<AttendanceRecord> selectByExample(AttendanceRecordExample example);

    AttendanceRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttendanceRecord record, @Param("example") AttendanceRecordExample example);

    int updateByExample(@Param("record") AttendanceRecord record, @Param("example") AttendanceRecordExample example);

    int updateByPrimaryKeySelective(AttendanceRecord record);

    int updateByPrimaryKey(AttendanceRecord record);

    List<AttendanceRecord> selectByUserId(Integer id);
}
