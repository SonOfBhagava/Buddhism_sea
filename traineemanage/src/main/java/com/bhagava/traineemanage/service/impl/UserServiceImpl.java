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
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserExample example) {
        return userMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> selectByExample(UserExample ex) {
        return userMapper.selectByExample(ex);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(User record, UserExample example) {
        return userMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(User record, UserExample example) {
        return userMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertList(List<User> list) {
        return userMapper.insertList(list);
    }

    @Override
    public List<Integer> selectGrroup(Integer classId) {
        return userMapper.selectGroup(classId);
    }
}
