package com.bhagava.traineemanage.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by FeiJunhao on ${date}
 */
public class Util {
    public static <T> Map<String,Object> getReturnMap(List<T> rows, long count){
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("rows",rows);
        map.put("pageCount",count);
        return map;
    }
}
