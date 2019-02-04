package com.bhagava.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/25 10:37
 * @Description: 保存有各种实体类与json字符串，实体类与MAP直接互相转换的方法
 */
public class EntitySwitchUtil {

    /**
     * 根据传入的JSON字符串和实体类类型，获得实体类对象
     * @param json
     * @param t
     * @param <T>
     * @return
     */
    public static  <T> T getEntityByJson(String json, Class<T> t){
        return JSONObject.parseObject(json,t);
    }

    /**
     * 根据传入的实体类，获得对应的JSON格式字符串
     * @param obj
     * @return
     */
    public static String getJsonByEntity(Object obj){
        return JSONObject.toJSONString(obj);
    }

    /**
     * 根据传入的jsonArray字符串和实体类类型，获得对应的实体类集合
     * @param jsonArray
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> getListByJsonArray(String jsonArray, Class<T> t){
        return JSONObject.parseArray(jsonArray, t);
    }

    /**
     * 根据传入的实体对象集合，获得对应的JSON数组字符串
     * @param list
     * @return
     */
    public static String getJsonArrayByList(List list){
        return JSON.toJSON(list).toString();
    }

    /**
     * 根据传入的jsonArray字符串获得map集合
     * @param str
     * @return
     */
    public static List<Map> getMapListByJsonArray(String str){
        List<Map> maps = JSONObject.parseArray(str,Map.class);
        return maps;
    }

    /**
     * 得到深克隆的实体对象
     * @param t 传入的实体对象
     * @return
     */
    public static <T> T getCloneEntity(T t){
        String json = JSONObject.toJSONString(t);
        return (T)JSONObject.parseObject(json, t.getClass());
    }

    /**
     * 实体类转换成Map的工具方法
     * @param t
     * @return
     */
    public static <T> Map<String, Object> getMapByEntity(T t) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : t.getClass().getDeclaredFields()){
            try {
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(t);
                map.put(field.getName(), o);
                field.setAccessible(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * map转换成实体类的工具方法
     * @param map
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> T getEntityByMap(Map<String, Object> map, Class<T> entity) {
        T t = null;
        try {
            t = entity.newInstance();
            for(Field field : entity.getDeclaredFields()) {
                if (map.containsKey(field.getName())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    Object object = map.get(field.getName());
                    if (object!= null && field.getType().isAssignableFrom(object.getClass())) {
                        field.set(t, object);
                    }
                    field.setAccessible(flag);
                }
            }
            return t;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }
    public static void main(String[] args) {

    }

}
