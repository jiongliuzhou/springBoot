package com.lz.base.util.json;

import com.alibaba.fastjson.JSONObject;

/**
 *  fastjson工具类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
public class JsonHelper {
    private JsonHelper(){

    }

    /**
     * 获取一个json字符串中的某个字符参数
     * @param key
     * @param json
     * @return
     */
    public static String getString(String key,String json){
        JSONObject jsonObject= JSONObject.parseObject(json);
        return jsonObject.getString(key);
    }

    /**
     * 获取一个json字符串中的某个整形参数
     * @param key
     * @param json
     * @return
     */
    public static Integer getInteger(String key,String json){
        JSONObject jsonObject= JSONObject.parseObject(json);
        return jsonObject.getInteger(key);
    }

    /**
     * 获取一个json字符串中的某个浮点型参数
     * @param key
     * @param json
     * @return
     */
    public static Double getDouble(String key,String json){
        JSONObject jsonObject= JSONObject.parseObject(json);
        return jsonObject.getDouble(key);
    }

    /**
     * 将json字符串转化为javabean
     * @param json json字符串
     * @param clazz 返回参数类型
     * @return
     */
    public static <T> T get(String json,Class<T> clazz){
        return JSONObject.parseObject(json, clazz);
    }

    /**
     * 将对象转化为json字符串
     * @param obj
     * @return
     */
    public static String toJSON(Object obj){
        return JSONObject.toJSON(obj).toString();
    }
}
