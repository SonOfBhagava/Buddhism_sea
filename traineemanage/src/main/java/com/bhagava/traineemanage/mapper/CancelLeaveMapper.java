package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.CancelLeave;
import com.bhagava.traineemanage.entity.CancelLeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelLeaveMapper {
    long countByExample(CancelLeaveExample example);

    int deleteByExample(CancelLeaveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CancelLeave record);

    int insertSelective(CancelLeave record);

    List<CancelLeave> selectByExample(CancelLeaveExample example);

    CancelLeave selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CancelLeave record, @Param("example") CancelLeaveExample example);

    int updateByExample(@Param("record") CancelLeave record, @Param("example") CancelLeaveExample example);

    int updateByPrimaryKeySelective(CancelLeave record);

    int updateByPrimaryKey(CancelLeave record);
}