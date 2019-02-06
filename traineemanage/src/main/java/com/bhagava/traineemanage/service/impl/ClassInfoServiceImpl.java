package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.ClassInfo;
import com.bhagava.traineemanage.entity.ClassInfoExample;
import com.bhagava.traineemanage.mapper.ClassInfoMapper;
import com.bhagava.traineemanage.service.ClassInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService{
    @Autowired
    private ClassInfoMapper classInfoMapper;

    @Override
    public long countByExample(ClassInfoExample example) {
        return classInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ClassInfo record) {
        return classInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ClassInfo record) {
        return classInfoMapper.insertSelective(record);
    }

    @Override
    public List<ClassInfo> selectByExample(ClassInfoExample example) {
        return classInfoMapper.selectByExample(example);
    }

    @Override
    public ClassInfo selectByPrimaryKey(Integer id) {
        return classInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassInfo record) {
        return classInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ClassInfo record) {
        return classInfoMapper.updateByPrimaryKey(record);
    }
}
