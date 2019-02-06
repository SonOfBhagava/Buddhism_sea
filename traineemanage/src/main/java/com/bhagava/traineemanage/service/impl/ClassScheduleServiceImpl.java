package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.ClassSchedule;
import com.bhagava.traineemanage.entity.ClassScheduleExample;
import com.bhagava.traineemanage.mapper.ClassScheduleMapper;
import com.bhagava.traineemanage.service.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@Service
public class ClassScheduleServiceImpl implements ClassScheduleService{
    @Autowired
    private ClassScheduleMapper classScheduleMapper;
    @Override
    public long countByExample(ClassScheduleExample example) {
        return classScheduleMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ClassScheduleExample example) {
        return classScheduleMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classScheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ClassSchedule record) {
        return classScheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(ClassSchedule record) {
        return classScheduleMapper.insertSelective(record);
    }

    @Override
    public List<ClassSchedule> selectByExample(ClassScheduleExample example) {
        return classScheduleMapper.selectByExample(example);
    }

    @Override
    public ClassSchedule selectByPrimaryKey(Integer id) {
        return classScheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ClassSchedule record, ClassScheduleExample example) {
        return classScheduleMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ClassSchedule record, ClassScheduleExample example) {
        return classScheduleMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassSchedule record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ClassSchedule record) {
        return 0;
    }
}
