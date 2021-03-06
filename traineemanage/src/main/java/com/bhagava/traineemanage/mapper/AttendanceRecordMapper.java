package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.AttendanceRecord;
import com.bhagava.traineemanage.entity.AttendanceRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AttendanceRecordMapper {
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

    @Select("select * from attendance_record where u_id = #{id}")
    List<AttendanceRecord> selectByUserId(Integer id);
}