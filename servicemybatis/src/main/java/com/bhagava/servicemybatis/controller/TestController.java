package com.bhagava.servicemybatis.controller;

import com.bhagava.servicemybatis.entity.*;
import com.bhagava.servicemybatis.service.TestService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TestController {


    @Autowired
    private TestService testService;

    @GetMapping("/getUpdateTests")
    public List<UpdateTest> getUpdateTests()
    {
        return testService.getUpdateTests();
    }

    //更新修改Test
    @PostMapping("/doUpdateTest")
    public int doUpdateTest(String reqStr)
    {
        HashMap<String,Object> obj = this.GetRequestData(reqStr);
        int id = Integer.parseInt(String.valueOf(obj.get("id")));
        String field1 = String.valueOf(obj.get("field1"));
        return testService.doUpdateTest(id,field1);
    }


    //获取添加Test列表
    @GetMapping("/getAddTests")
    public List<AddTest> getAddTests()
    {
        return testService.getAddTests();
    }


    //添加Test
    @PostMapping("/doAddTest")
    public ResponseModel doAddTest(@RequestBody String reqStr)
    {
        HashMap<String,Object> obj = this.GetRequestData(reqStr);
        int id = Integer.parseInt(String.valueOf(obj.get("id")));
        String field1 = String.valueOf(obj.get("field1"));
        String field2 = String.valueOf(obj.get("field2"));
        int fnum = Integer.parseInt(String.valueOf(obj.get("fnum")));

        int result = testService.doAddTest(id,field1,field2,fnum);

        ResponseModel model = new ResponseModel();
        if(result == 1)//表示插入成功
        {
            model.setRflag(ResponseModel.SUCCESS);
        }
        else
        {
            model.setRflag(ResponseModel.ERROR);
            model.setMsg("数据并没有插入进对应数据库");
        }

        return model;
    }


    //获取删除Test列表
    @GetMapping("/getDelTest")
    public List<DelTest> getDelTest()
    {
        return testService.getDelTest();
    }
    //删除Test
    @PostMapping("/doDelTest")
    public int doDelTest(String reqStr)
    {
        HashMap<String,Object> obj = this.GetRequestData(reqStr);
        int id = Integer.parseInt(String.valueOf(obj.get("id")));

        return testService.doDelTest(id);
    }

    private HashMap<String,Object> GetRequestData(String reqStr) {
        HashMap<String, Object> map = new HashMap<>();
        //初始化
        map.put("id", -1);
        map.put("field1", "");
        map.put("field2", "");
        map.put("fnum",-1);


        JSONObject obj = JSON.parseObject(reqStr);
        map.put("id", obj.getInteger("id"));
        map.put("field1", obj.getString("field1"));
        map.put("field2", obj.getString("field2"));
        map.put("fnum",obj.getInteger("fnum"));

        return map;
    }

}
