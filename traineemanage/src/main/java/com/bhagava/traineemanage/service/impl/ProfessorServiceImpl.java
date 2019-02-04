package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.Professor;
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
    public int insertList(List<Professor> list) {
        return professorMapper.insertList(list);
    }
}
