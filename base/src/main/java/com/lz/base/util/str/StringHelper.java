package com.lz.base.util.str;

/**
 *  字符串工具类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
public class StringHelper {
    private StringHelper(){

    }

    /**
     * 判断字符串是否为null或者""
     * @param str 字符串
     * @return
     */
    public static Boolean isEmpty(String str){
        return str==null || "".equals(str);
    }

    /**
     * 判断字符串不为为null和""
     * @param str 字符串
     * @return
     */
    public static Boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 字符串首字母大写
     * @param str 字符串
     * @return
     */
    public static String firstCharUpper(String str){
        if(isNotEmpty(str)){
            return str.substring(0,1).toUpperCase()+str.substring(1,str.length());
        }
        return str;
    }

    /**
     * 将字符串null转化为""
     * @param str 字符串
     * @return 如果str==null返回“”，否则返回原字符串
     */
    public static String null2str(String str){
        return str==null?"":str;
    }

    /**
     * 将字符串""转化为null
     * @param str 字符串
     * @return 如果str==""返回null，否则返回原字符串
     */
    public static String str2null(String str){
        return "".equals(str)?null:str;
    }

}
