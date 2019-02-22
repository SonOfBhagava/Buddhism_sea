package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.ClassExam;
import com.bhagava.traineemanage.entity.ClassExamExample;
import com.bhagava.traineemanage.mapper.ClassExamMapper;
import com.bhagava.traineemanage.service.ClassExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/2/21 14:13
 * @Description:
 */
@Service
public class ClassExamServiceImpl implements ClassExamService{

    @Autowired
    private ClassExamMapper classExamMapper;

    @Override
    public long countByExample(ClassExamExample example) {
        return classExamMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ClassExamExample example) {
        return classExamMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classExamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ClassExam record) {
        return classExamMapper.insert(record);
    }

    @Override
    public int insertSelective(ClassExam record) {
        return classExamMapper.insertSelective(record);
    }

    @Override
    public List<ClassExam> selectByExample(ClassExamExample example) {
        return classExamMapper.selectByExample(example);
    }

    @Override
    public ClassExam selectByPrimaryKey(Integer id) {
        return classExamMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ClassExam record, ClassExamExample example) {
        return classExamMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ClassExam record, ClassExamExample example) {
        return classExamMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassExam record) {
        return classExamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ClassExam record) {
        return classExamMapper.updateByPrimaryKey(record);
    }
}
