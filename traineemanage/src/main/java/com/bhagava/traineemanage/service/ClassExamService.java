package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.ClassExam;
import com.bhagava.traineemanage.entity.ClassExamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/2/21 14:12
 * @Description:
 */
public interface ClassExamService {
    long countByExample(ClassExamExample example);

    int deleteByExample(ClassExamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassExam record);

    int insertSelective(ClassExam record);

    List<ClassExam> selectByExample(ClassExamExample example);

    ClassExam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassExam record, @Param("example") ClassExamExample example);

    int updateByExample(@Param("record") ClassExam record, @Param("example") ClassExamExample example);

    int updateByPrimaryKeySelective(ClassExam record);

    int updateByPrimaryKey(ClassExam record);
}
