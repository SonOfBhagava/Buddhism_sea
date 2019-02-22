package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.ExamClassify;
import com.bhagava.traineemanage.entity.ExamClassifyExample;
import com.bhagava.traineemanage.mapper.ExamClassifyMapper;
import com.bhagava.traineemanage.service.ExamClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/2/21 14:19
 * @Description:
 */
@Service
public class ExamClassifyServiceImpl implements ExamClassifyService{
    @Autowired
    private ExamClassifyMapper examClassifyMapper;

    @Override
    public long countByExample(ExamClassifyExample example) {
        return examClassifyMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ExamClassifyExample example) {
        return examClassifyMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return examClassifyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ExamClassify record) {
        return examClassifyMapper.insert(record);
    }

    @Override
    public int insertSelective(ExamClassify record) {
        return examClassifyMapper.insertSelective(record);
    }

    @Override
    public List<ExamClassify> selectByExampleWithBLOBs(ExamClassifyExample example) {
        return examClassifyMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ExamClassify> selectByExample(ExamClassifyExample example) {
        return examClassifyMapper.selectByExample(example);
    }

    @Override
    public ExamClassify selectByPrimaryKey(Integer id) {
        return examClassifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ExamClassify record, ExamClassifyExample example) {
        return examClassifyMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExampleWithBLOBs(ExamClassify record, ExamClassifyExample example) {
        return examClassifyMapper.updateByExampleWithBLOBs(record,example);
    }

    @Override
    public int updateByExample(ExamClassify record, ExamClassifyExample example) {
        return examClassifyMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ExamClassify record) {
        return examClassifyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ExamClassify record) {
        return examClassifyMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(ExamClassify record) {
        return examClassifyMapper.updateByPrimaryKey(record);
    }
}
