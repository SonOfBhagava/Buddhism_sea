package com.bhagava.common.service;


/**
 * created by FeiJunhao on ${date}
 */
public interface BaseService {
    <T> long countByExample(T example);

    <T> int deleteByExample(T example);

    <T> int deleteByPrimaryKey(Integer id);

    <T> int insert(T record);

    <T> int insertSelective(T record);

    <T> T selectByPrimaryKey(Integer id);

    <T> int updateByPrimaryKeySelective(T record);

    <T> int updateByPrimaryKey(T record);
}
