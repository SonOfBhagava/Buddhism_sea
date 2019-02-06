package com.bhagava.traineemanage.mapper;

import com.bhagava.traineemanage.entity.ClassInfo;
import com.bhagava.traineemanage.entity.ClassInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoMapper {
    @Select("select * from class_info order by desc")
    List<ClassInfo> selectAll();

    long countByExample(ClassInfoExample example);

    int deleteByExample(ClassInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    List<ClassInfo> selectByExample(ClassInfoExample example);

    ClassInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    int updateByExample(@Param("record") ClassInfo record, @Param("example") ClassInfoExample example);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);

    @Select("select name from class_info where id = ${id} limit 1")
    String selectNameByKey(Integer id);

    @Select("select name from class_info")
    List<String> selectAllClassName();
}