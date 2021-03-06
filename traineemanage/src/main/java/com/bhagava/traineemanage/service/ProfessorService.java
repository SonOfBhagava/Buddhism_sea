package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.Professor;
import com.bhagava.traineemanage.entity.ProfessorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public interface ProfessorService {
    long countByExample(ProfessorExample example);

    int deleteByExample(ProfessorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Professor record);

    int insertSelective(Professor record);

    List<Professor> selectByExample(ProfessorExample example);

    Professor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Professor record, @Param("example") ProfessorExample example);

    int updateByExample(@Param("record") Professor record, @Param("example") ProfessorExample example);

    int updateByPrimaryKeySelective(Professor record);

    int updateByPrimaryKey(Professor record);

    int insertList(List<Professor> list);
}
