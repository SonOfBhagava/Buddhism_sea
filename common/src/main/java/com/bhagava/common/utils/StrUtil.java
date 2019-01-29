package com.bhagava.common.utils;

import java.util.List;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/25 11:03
 * @Description: 提供字符串转换，其他数据类型的对象转换成字符串的工具类
 */
public class StrUtil {

    /**
     * 将基本数据类型集合转换成数组字符串的方法
     * @param list
     * @return 例："[a,b,c,d,e]"
     */
    public <T> String getArrayStringByList(List<T> list){
        String str = "[";
        if(list.size() > 0){
            for(int i = 0;i < list.size();i++){
                str += "\""+ String.valueOf(list.get(i)) + "\",";
            }
        }
        str = str.length() > 1 ? str.substring(0,str.length()-1) + "]":"[]";
        return str;
    }
}
