package com.bhagava.traineemanage.controller;

import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.entity.UserExample;
import com.bhagava.traineemanage.mapper.UserMapper;
import com.bhagava.traineemanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/28 15:57
 * @Description:
 */
@RestController
@CrossOrigin
public class TestController {
    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public String toTest(){
        return "/index.html";
    }

    @GetMapping("/testSql")
    public String testSql(){
        UserExample ex = new UserExample();
        UserExample.Criteria cri = ex.createCriteria();
        cri.andIdBetween(2,4);
        List<User> list = userService.selectByExample(ex);
        System.out.println(list.get(0).getId());
        return "1";
    }

    @PostMapping("/login")
    public Object login(String userName,String password){
        System.out.println("账号：" + userName);
        System.out.println("密码：" + password);
        return "token";
    }

    @GetMapping("/get_info")
    public Object getUserInfo(String token){
        System.out.println("token:" + token);
        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("name","manage");
        userInfo.put("user_id","1");
        userInfo.put("access",new String[]{"super_admin","admin"});
        userInfo.put("token","super_admin");
        userInfo.put("avator","https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        String str = "{" +
                "    name: 'super_admin'," +
                "    user_id: '1'," +
                "    access: ['super_admin', 'admin']," +
                "    token: 'super_admin'," +
                "    avator: 'https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png'" +
                "  }";
        return userInfo;
    }
}
