package com.lz.base.util.bean;

import com.lz.base.util.str.StringHelper;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 对象操作工具类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
@Slf4j
public class BeanHelper {
    private BeanHelper(){

    }

    /**
     * 将对象中的字符串null值转化为""
     * @param data 对象值
     * @param <T> 泛型
     */
    public static<T extends Object> void null2str(T data){
        Class<? extends Object> aClass = data.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field:declaredFields){
            Object value=invokeGet(aClass,data,field);
            //如果属性值为null并且是字符串则将其值转化为""
            if(value==null && String.class.isAssignableFrom(field.getType())){
                invokeSet(aClass,data,field,"");
            }
        }
    }

    /**
     *  将一个对象值的属性复制到另一个对象(对象中属性名、属性类型要完全相同)
     *  1、原始字段属性值为非空
     *  2、原始字段名称与新字段名称相同
     * @param oldObj 原对象
     * @param newObj 新对象
     * @param <T>
     * @param <K>
     */
    public static<T extends Object,K extends Object> void propertyCopy(T oldObj,K newObj){
        Class<? extends Object> oClass = oldObj.getClass();
        Class<? extends Object> nClass = newObj.getClass();
        Field[] oldFields = oClass.getDeclaredFields();
        Field[] newFields = nClass.getDeclaredFields();
        for (Field odlField:oldFields){
            //属性值不为空
            Object oldValue=invokeGet(oClass,oldObj,odlField);
            if(oldValue!=null){
                for(Field newField:newFields){
                    //属性名称相同
                    if(odlField.getName().equals(newField.getName())){
                        //属性类型相同
                        if(odlField.getType().isAssignableFrom(newField.getType())){
                            invokeSet(nClass,newObj,newField,oldValue);
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 实行get方法
     * @param nClass class对象
     * @param obj 对象
     * @param field 属性
     * @return 返回值
     */
    private static Object invokeGet(Class nClass,Object obj,Field field){
        Object value=null;
        try{
            String getMethod = "get"+ StringHelper.firstCharUpper(field.getName());
            Method method = nClass.getMethod(getMethod);
            value = method.invoke(obj);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return value;
    }

    /**
     * 执行set方法
     * @param nClass class对象
     * @param obj 对象
     * @param field 对象的属性
     * @param value 属性值
     */
    private static void invokeSet(Class nClass,Object obj,Field field,Object value){
        try {
            String setMethod = "set"+ StringHelper.firstCharUpper(field.getName());
            Method method = nClass.getMethod(setMethod, field.getType());
            method.invoke(obj,value);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

}
