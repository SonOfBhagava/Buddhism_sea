package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.Volunteer;
import com.bhagava.traineemanage.entity.VolunteerExample;
import com.bhagava.traineemanage.mapper.VolunteerMapper;
import com.bhagava.traineemanage.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@Service
public class VolunteerServiceImpl implements VolunteerService{
    @Autowired
    VolunteerMapper volunteerMapper;
    @Override
    public long countByExample(VolunteerExample example) {
        return volunteerMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(VolunteerExample example) {
        return volunteerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return volunteerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Volunteer record) {
        return volunteerMapper.insert(record);
    }

    @Override
    public int insertSelective(Volunteer record) {
        return volunteerMapper.insert(record);
    }

    @Override
    public List<Volunteer> selectByExample(VolunteerExample example) {
        return volunteerMapper.selectByExample(example);
    }

    @Override
    public Volunteer selectByPrimaryKey(Integer id) {
        return volunteerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Volunteer record, VolunteerExample example) {
        return updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Volunteer record, VolunteerExample example) {
        return volunteerMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Volunteer record) {
        return volunteerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Volunteer record) {
        return volunteerMapper.updateByPrimaryKey(record);
    }
}
