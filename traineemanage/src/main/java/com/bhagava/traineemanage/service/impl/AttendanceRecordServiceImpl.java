package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.AttendanceRecord;
import com.bhagava.traineemanage.entity.AttendanceRecordExample;
import com.bhagava.traineemanage.mapper.AttendanceRecordMapper;
import com.bhagava.traineemanage.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordService{
    @Autowired
    AttendanceRecordMapper attendanceRecordMapper;

    @Override
    public long countByExample(AttendanceRecordExample example) {
        return attendanceRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AttendanceRecordExample example) {
        return attendanceRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attendanceRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AttendanceRecord record) {
        return attendanceRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(AttendanceRecord record) {
        return attendanceRecordMapper.insertSelective(record);
    }

    @Override
    public List<AttendanceRecord> selectByExample(AttendanceRecordExample example) {
        return attendanceRecordMapper.selectByExample(example);
    }

    @Override
    public AttendanceRecord selectByPrimaryKey(Integer id) {
        return attendanceRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(AttendanceRecord record, AttendanceRecordExample example) {
        return attendanceRecordMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(AttendanceRecord record, AttendanceRecordExample example) {
        return attendanceRecordMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(AttendanceRecord record) {
        return attendanceRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AttendanceRecord record) {
        return attendanceRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AttendanceRecord> selectByUserId(Integer id) {
        return attendanceRecordMapper.selectByUserId(id);
    }
}
