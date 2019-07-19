package com.lz.base.util.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数学计算方法
 * @author lz
 * @create 2019/7/8
 * @since 1.0.0
 */
public class MathHelper {
    private  MathHelper(){

    }
    /**
     * 加法
     * @param one 加数1
     * @param two 加数2
     * @param scale 保留小数位数
     * @return
     */
    public static String add(String one,String two,int ... scale){
        BigDecimal o=new BigDecimal(one);
        BigDecimal t=new BigDecimal(two);
        BigDecimal result=o.add(t);
        if(scale!=null && scale.length==1){
            result=result.setScale(scale[0], RoundingMode.HALF_UP);
        }
        return result.toString();
    }

    /**
     * 减法
     * @param one 被减数
     * @param two 减数
     * @param scale 保留小数位数
     * @return
     */
    public static String subtract(String one,String two,int ... scale){
        BigDecimal o=new BigDecimal(one);
        BigDecimal t=new BigDecimal(two);
        BigDecimal result=o.subtract(t);
        if(scale!=null && scale.length==1){
            result=result.setScale(scale[0], RoundingMode.HALF_UP);
        }
        return result.toString();
    }

    /**
     * 乘法
     * @param one 乘数1
     * @param two 乘数1
     * @param scale 保留小数位数
     * @return
     */
    public static String multiply(String one,String two,int ... scale){
        BigDecimal o=new BigDecimal(one);
        BigDecimal t=new BigDecimal(two);
        BigDecimal result=o.multiply(t);
        if(scale!=null && scale.length==1){
            result=result.setScale(scale[0], RoundingMode.HALF_UP);
        }
        return result.toString();
    }

    /**
     * 除法
     * @param one 被除数
     * @param two 除数
     * @param scale 保留小数位数
     * @return
     */
    public static String divide(String one,String two,int ... scale){
        BigDecimal o=new BigDecimal(one);
        BigDecimal t=new BigDecimal(two);
        BigDecimal result=o.divide(t);
        if(scale!=null && scale.length==1){
            result=result.setScale(scale[0], RoundingMode.HALF_UP);
        }
        return result.toString();
    }
}
