package com.bhagava.servicemybatis.mapper;

import com.bhagava.servicemybatis.entity.*;
import com.bhagava.servicemybatis.entity.UpdateTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface TestMapper {
    //获取修改Test
    List<UpdateTest> getUpdateTests();
    //更新修改Test
    int doUpdateTest(@Param("id") int id, @Param("field1") String field1);

    //获取添加Test列表
    List<AddTest> getAddTests();
    //添加Test
    int doAddTest(@Param("id") int id, @Param("field1") String field1, @Param("field2") String field2, @Param("fnum") int fnum);

    //获取删除Test列表
    List<DelTest> getDelTest();
    //删除Test
    int doDelTest(@Param("id") int id);
}
