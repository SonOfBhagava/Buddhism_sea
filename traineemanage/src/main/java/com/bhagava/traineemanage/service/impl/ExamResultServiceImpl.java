package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.ExamResult;
import com.bhagava.traineemanage.entity.ExamResultExample;
import com.bhagava.traineemanage.mapper.ExamResultMapper;
import com.bhagava.traineemanage.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/2/21 14:25
 * @Description:
 */
@Service
public class ExamResultServiceImpl implements ExamResultService{
    @Autowired
    private ExamResultMapper examResultMapper;
    @Override
    public long countByExample(ExamResultExample example) {
        return examResultMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ExamResultExample example) {
        return examResultMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return examResultMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ExamResult record) {
        return examResultMapper.insert(record);
    }

    @Override
    public int insertSelective(ExamResult record) {
        return examResultMapper.insertSelective(record);
    }

    @Override
    public List<ExamResult> selectByExample(ExamResultExample example) {
        return examResultMapper.selectByExample(example);
    }

    @Override
    public ExamResult selectByPrimaryKey(Integer id) {
        return examResultMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ExamResult record, ExamResultExample example) {
        return examResultMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ExamResult record, ExamResultExample example) {
        return examResultMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ExamResult record) {
        return examResultMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ExamResult record) {
        return examResultMapper.updateByPrimaryKey(record);
    }
}
