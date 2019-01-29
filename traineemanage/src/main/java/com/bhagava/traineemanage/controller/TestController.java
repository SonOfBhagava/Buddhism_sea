package com.bhagava.traineemanage.controller;

import com.bhagava.traineemanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/28 15:57
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String toTest(){
        return "/index.html";
    }

    @GetMapping("/testSql")
    public String testSql(){
        String name = userService.selectById(1).getName();
        System.out.println(name);
        return name;
    }
}
