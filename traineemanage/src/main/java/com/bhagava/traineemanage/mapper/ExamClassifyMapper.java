package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.ExamClassify;
import com.bhagava.traineemanage.entity.ExamClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ExamClassifyMapper {
    long countByExample(ExamClassifyExample example);

    int deleteByExample(ExamClassifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamClassify record);

    int insertSelective(ExamClassify record);

    List<ExamClassify> selectByExampleWithBLOBs(ExamClassifyExample example);

    List<ExamClassify> selectByExample(ExamClassifyExample example);

    ExamClassify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamClassify record, @Param("example") ExamClassifyExample example);

    int updateByExampleWithBLOBs(@Param("record") ExamClassify record, @Param("example") ExamClassifyExample example);

    int updateByExample(@Param("record") ExamClassify record, @Param("example") ExamClassifyExample example);

    int updateByPrimaryKeySelective(ExamClassify record);

    int updateByPrimaryKeyWithBLOBs(ExamClassify record);

    int updateByPrimaryKey(ExamClassify record);

    @Select("select * from exam_classify where id = #{id}")
    ExamClassify selectByExamClassifyId(Integer id);
}