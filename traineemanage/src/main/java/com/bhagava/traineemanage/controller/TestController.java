package com.bhagava.traineemanage.controller;

import com.bhagava.traineemanage.service.ProfessorService;
import com.bhagava.traineemanage.service.UserService;
import com.bhagava.traineemanage.util.DataProductTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @Autowired
    private ProfessorService professorService;


    @GetMapping("/test")
    public String toTest(){
        return "/index.html";
    }

    @GetMapping("/testSql")
    public int testSql(){
//        return DataProductTool.productUserInfo(20,1,3,userService);
        return DataProductTool.productProfessor(25,professorService);
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

    public static void main(String[] args) {

    }
}
