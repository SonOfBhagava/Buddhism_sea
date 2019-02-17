package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.VolunteerValidDateExample;
import com.bhagava.traineemanage.mapper.VolunteerValidDateMapper;
import com.bhagava.traineemanage.service.VolunteerValidDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@Service
public class VolunteerValidDateServiceImpl implements VolunteerValidDateService {
    @Autowired
    VolunteerValidDateMapper volunteerValidDateMapper;
    @Override
    public long countByExample(VolunteerValidDateExample example) {
        return volunteerValidDateMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(VolunteerValidDateExample example) {
        return volunteerValidDateMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return volunteerValidDateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(com.bhagava.traineemanage.entity.VolunteerValidDate record) {
        return volunteerValidDateMapper.insert(record);
    }

    @Override
    public int insertSelective(com.bhagava.traineemanage.entity.VolunteerValidDate record) {
        return volunteerValidDateMapper.insertSelective(record);
    }

    @Override
    public List<com.bhagava.traineemanage.entity.VolunteerValidDate> selectByExample(VolunteerValidDateExample example) {
        return volunteerValidDateMapper.selectByExample(example);
    }

    @Override
    public com.bhagava.traineemanage.entity.VolunteerValidDate selectByPrimaryKey(Integer id) {
        return volunteerValidDateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(com.bhagava.traineemanage.entity.VolunteerValidDate record, VolunteerValidDateExample example) {
        return volunteerValidDateMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(com.bhagava.traineemanage.entity.VolunteerValidDate record, VolunteerValidDateExample example) {
        return volunteerValidDateMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(com.bhagava.traineemanage.entity.VolunteerValidDate record) {
        return volunteerValidDateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(com.bhagava.traineemanage.entity.VolunteerValidDate record) {
        return volunteerValidDateMapper.updateByPrimaryKey(record);
    }
}
