package com.bhagava.traineemanage.service;

import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.entity.UserExample;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/28 15:59
 * @Description:
 */

public interface UserService {
    User selectById(int id);

    List<User> selectByExample(UserExample ex);

    int insertList(List<User> list);
}
