package com.bhagava.servicemybatis.service;

import com.bhagava.servicemybatis.entity.*;
import com.bhagava.servicemybatis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    public TestMapper testMapper;

    public List<UpdateTest> getUpdateTests()
    {
        return testMapper.getUpdateTests();
    }

    //更新修改Test
    public int doUpdateTest(int id, String field1)
    {
        return testMapper.doUpdateTest(id,field1);
    }

    //获取添加Test列表
    public List<AddTest> getAddTests()
    {
        return testMapper.getAddTests();
    }

    //添加Test
    public int doAddTest(int id,String field1,String field2,int fnum)
    {
        return testMapper.doAddTest(id,field1,field2,fnum);
    }

    //获取删除Test列表
    public List<DelTest> getDelTest()
    {
        return testMapper.getDelTest();
    }
    //删除Test
    public int doDelTest(int id)
    {
        return testMapper.doDelTest(id);
    }
}
