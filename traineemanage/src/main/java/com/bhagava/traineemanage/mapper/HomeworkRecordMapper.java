package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.HomeworkRecord;
import com.bhagava.traineemanage.entity.HomeworkRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRecordMapper {
    long countByExample(HomeworkRecordExample example);

    int deleteByExample(HomeworkRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HomeworkRecord record);

    int insertSelective(HomeworkRecord record);

    List<HomeworkRecord> selectByExample(HomeworkRecordExample example);

    HomeworkRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HomeworkRecord record, @Param("example") HomeworkRecordExample example);

    int updateByExample(@Param("record") HomeworkRecord record, @Param("example") HomeworkRecordExample example);

    int updateByPrimaryKeySelective(HomeworkRecord record);

    int updateByPrimaryKey(HomeworkRecord record);
}