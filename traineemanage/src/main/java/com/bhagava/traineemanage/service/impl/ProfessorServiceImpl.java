package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.Professor;
import com.bhagava.traineemanage.entity.ProfessorExample;
import com.bhagava.traineemanage.mapper.ProfessorMapper;
import com.bhagava.traineemanage.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    ProfessorMapper professorMapper;

    @Override
    public long countByExample(ProfessorExample example) {
        return professorMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProfessorExample example) {
        return professorMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return professorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Professor record) {
        return professorMapper.insert(record);
    }

    @Override
    public int insertSelective(Professor record) {
        return professorMapper.insertSelective(record);
    }

    @Override
    public List<Professor> selectByExample(ProfessorExample example) {
        return selectByExample(example);
    }

    @Override
    public Professor selectByPrimaryKey(Integer id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Professor record, ProfessorExample example) {
        return professorMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Professor record, ProfessorExample example) {
        return professorMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Professor record) {
        return professorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Professor record) {
        return professorMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertList(List<Professor> list) {
        return professorMapper.insertList(list);
    }
}
