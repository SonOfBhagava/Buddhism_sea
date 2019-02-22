package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.ExamResult;
import com.bhagava.traineemanage.entity.ExamResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/2/21 14:17
 * @Description:
 */
public interface ExamResultService {
    long countByExample(ExamResultExample example);

    int deleteByExample(ExamResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExamResult record);

    int insertSelective(ExamResult record);

    List<ExamResult> selectByExample(ExamResultExample example);

    ExamResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExamResult record, @Param("example") ExamResultExample example);

    int updateByExample(@Param("record") ExamResult record, @Param("example") ExamResultExample example);

    int updateByPrimaryKeySelective(ExamResult record);

    int updateByPrimaryKey(ExamResult record);
}
