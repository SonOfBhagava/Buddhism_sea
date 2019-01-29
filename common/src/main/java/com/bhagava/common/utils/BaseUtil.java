package com.bhagava.common.utils;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/25 10:37
 * @Description: 要使用公共业务方法必须要实现的工具类接口
 */
public interface BaseUtil {
    /**
     * 根据集合得到集合requestID拼接成字符串作为SQL去重参数的接口方法
     * @param list
     * @param <T>
     * @return 例：id1,id2,id3,id4.....
     */
    public <T> String getJointStringByList(List<T> list);
}
