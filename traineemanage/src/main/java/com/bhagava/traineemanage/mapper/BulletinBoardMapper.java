package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.BulletinBoard;
import com.bhagava.traineemanage.entity.BulletinBoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BulletinBoardMapper {
    long countByExample(BulletinBoardExample example);

    int deleteByExample(BulletinBoardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BulletinBoard record);

    int insertSelective(BulletinBoard record);

    List<BulletinBoard> selectByExampleWithBLOBs(BulletinBoardExample example);

    List<BulletinBoard> selectByExample(BulletinBoardExample example);

    BulletinBoard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BulletinBoard record, @Param("example") BulletinBoardExample example);

    int updateByExampleWithBLOBs(@Param("record") BulletinBoard record, @Param("example") BulletinBoardExample example);

    int updateByExample(@Param("record") BulletinBoard record, @Param("example") BulletinBoardExample example);

    int updateByPrimaryKeySelective(BulletinBoard record);

    int updateByPrimaryKeyWithBLOBs(BulletinBoard record);

    int updateByPrimaryKey(BulletinBoard record);
}