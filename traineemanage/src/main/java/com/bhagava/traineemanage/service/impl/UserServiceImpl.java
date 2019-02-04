package com.bhagava.traineemanage.service.impl;

import com.bhagava.traineemanage.entity.User;
import com.bhagava.traineemanage.entity.UserExample;
import com.bhagava.traineemanage.mapper.UserMapper;
import com.bhagava.traineemanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/28 15:59
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectByExample(UserExample ex) {
        return userMapper.selectByExample(ex);
    }

    @Override
    public int insertList(List<User> list) {
        return userMapper.insertList(list);
    }
}
