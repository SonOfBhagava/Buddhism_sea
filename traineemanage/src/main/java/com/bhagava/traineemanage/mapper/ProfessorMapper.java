package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.Professor;
import com.bhagava.traineemanage.entity.ProfessorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorMapper {
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

    @Select("select name from professor where id = ${ id }")
    String getProfessorName(Integer id);
}