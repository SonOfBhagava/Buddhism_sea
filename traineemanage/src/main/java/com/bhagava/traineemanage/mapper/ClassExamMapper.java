package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.ClassExam;
import com.bhagava.traineemanage.entity.ClassExamExample;
import java.util.List;

import com.bhagava.traineemanage.entity.ExamClassify;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ClassExamMapper {
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

    @Select("select * from class_exam where class_id = #{classId}")
    List<ClassExam> selectByClassId(Integer classId);

}