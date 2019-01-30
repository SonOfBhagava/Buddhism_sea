package com.bhagava.traineemanage.controller;

import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.entity.UserExample;
import com.bhagava.traineemanage.mapper.UserMapper;
import com.bhagava.traineemanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        String str = "{\n" +
                "    name: 'super_admin',\n" +
                "    user_id: '1',\n" +
                "    access: ['super_admin', 'admin'],\n" +
                "    token: 'super_admin',\n" +
                "    avator: 'https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png'\n" +
                "  }";
        return str;
    }
}
