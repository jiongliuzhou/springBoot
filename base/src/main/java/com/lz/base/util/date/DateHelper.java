package com.lz.base.util.date;

import com.lz.base.constant.ConstantInt;
import com.lz.base.constant.ConstantStr;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  日期工具类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
@Slf4j
public class DateHelper {
    private DateHelper(){

    }

    /**
     *  获取当前时间字符串
     * @param fmt 时间格式
     * @return 返回当前时间字符串
     */
    public static String getNow(String fmt){
        return date2str(new Date(),fmt);
    }

    /**
     * 获取当前时间字符串（格式为：yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getNow(){
        return date2str(new Date(), ConstantStr.FMT2.getKey());
    }

    /**
     * 将日期字符串进行格式转化
     * @param date 字符串格式日期
     * @param oldFmt 原字符串格式
     * @param newFmt 新字符串格式
     * @return 字符串格式日期
     */
    public static String dateFmt(String date,String oldFmt,String newFmt){
        Date date1 = str2date(date, oldFmt);
        return date2str(date1,newFmt);
    }

    public static Date dateFmt(Long m){
        return new Date(m);
    }

    /**
     *  将日期类型转化为字符串类型
     * @param date 日期类型
     * @param fmt 转化格式
     * @return 返回日期对应的字符串
     */
    public static String date2str(Date date,String fmt){
        if(date==null){
            throw new NullPointerException();
        }
        SimpleDateFormat sdf=new SimpleDateFormat(fmt);
        return sdf.format(date);
    }

    /**
     *  将日期类型转化为字符串类型
     * @param m 毫秒
     * @param fmt 转化格式
     * @return 返回日期对应的字符串
     */
    public static String date2str(Long m,String fmt){
        return date2str(new Date(m),fmt);
    }

    /**
     *  将日期字符串转化为日期类型
     * @param date 日期字符串
     * @param fmt 日期类型
     * @return 返回日期类型
     */
    public static Date str2date(String date,String fmt){
        SimpleDateFormat sdf=new SimpleDateFormat(fmt);
        Date parse=null;
        try {
            parse = sdf.parse(date);
        }catch (ParseException e){
            log.error(e.getMessage());
        }
        return parse;
    }

    /**
     * 毫秒转化为日期类型
     * @param m 毫秒
     * @return 日期类型
     */
    public static Date milli2date(Long m){
        return new Date(m);
    }

    /**
     * 计算给定时间对应的时间差
     * @param date 日期字符串
     * @param oldFmt 给定字符串格式
     * @param newFmt 计算时间差后的日期格式
     * @param timeType 时间单位类型（年:yyyy、月:MM、日:dd、时:HH、分：mm、秒:ss，毫秒:milli）
     * @param diff 时间差（毫秒）(负数时间往前推)
     * @return 返回日期字符串
     */
    public static String dateDiff(String date,String oldFmt,String newFmt,String timeType,Long diff){
        long d=diff;
        if(ConstantStr.FMT.getKey().equals(timeType)){//年
            d*= ConstantInt.ONE_THOUSAND.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.TWENTY_FOUR.getKey();
            d*=(isLeapYear(date,oldFmt)? ConstantInt.YEAR_366.getKey(): ConstantInt.YEAR_365.getKey());
        }else if(ConstantStr.FMT_1.getKey().equals(timeType)){//月
            d*= ConstantInt.ONE_THOUSAND.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.TWENTY_FOUR.getKey();
            d*=getDaysOfMonth(date,oldFmt);
        }else if(ConstantStr.FMT_2.getKey().equals(timeType)){//日
            d*= ConstantInt.ONE_THOUSAND.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.TWENTY_FOUR.getKey();
        }else if(ConstantStr.FMT_3.getKey().equals(timeType)){//时
            d*= ConstantInt.ONE_THOUSAND.getKey()* ConstantInt.SIXTY.getKey()* ConstantInt.SIXTY.getKey();
        }else if(ConstantStr.FMT_4.getKey().equals(timeType)){//分
            d*= ConstantInt.ONE_THOUSAND.getKey()* ConstantInt.SIXTY.getKey();
        }else if(ConstantStr.FMT_5.getKey().equals(timeType)){//秒
            d*= ConstantInt.ONE_THOUSAND.getKey();
        }
        Date dateTime=str2date(date,oldFmt);
        if(dateTime!=null){
            d+=dateTime.getTime();
        }
        return date2str(d,newFmt);
    }

    /**
     * 判断是否为闰年
     * @param date 时间
     * @param fmt 时间格式
     * @return
     */
    public static Boolean isLeapYear(String date,String fmt){
        boolean flag=false;
        String s = dateFmt(date, fmt, ConstantStr.FMT.getKey());
        int year=Integer.parseInt(s);
        if(year% ConstantInt.FOUR_HUNDRED.getKey()==0 ||
                (year% ConstantInt.FOUR.getKey()==0 && year% ConstantInt.ONE_HUNDRED.getKey()!=0)){
            flag=true;
        }
        return flag;
    }

    /**
     * 获取指定日期年份有多少天
     * @param date 日期
     * @param fmt 日期格式字符串
     * @return 返回日期所在年的天数
     */
    public static int getDaysOfYear(String date,String fmt){
        return isLeapYear(date,fmt)? ConstantInt.YEAR_366.getKey(): ConstantInt.YEAR_365.getKey();
    }

    /**
     * 获取给定时间月份有多少天
     * @param date 时间
     * @param fmt 时间格式
     * @return 返回日期所在月份天数
     */
    public static Integer getDaysOfMonth(String date,String fmt){
        String s = dateFmt(date, fmt, ConstantStr.FMT_1.getKey());
        int month=Integer.parseInt(s);
        //月大
        if(ConstantInt.ONE.getKey().equals(month) || ConstantInt.THRE.getKey().equals(month)
                || ConstantInt.FIVE.getKey().equals(month) || ConstantInt.SEVEN.getKey().equals(month)
                || ConstantInt.EIGHT.getKey().equals(month) || ConstantInt.TEN.getKey().equals(month)
                || ConstantInt.TWELVE.getKey().equals(month)){
            return ConstantInt.THIRTY_ONE.getKey();
        }else if(ConstantInt.TWO.getKey().equals(month)){//二月
            return isLeapYear(date,fmt)? ConstantInt.TWENTY_NINE.getKey(): ConstantInt.TWENTY_EIGHT.getKey();
        }else{//月小
            return ConstantInt.THIRTY.getKey();
        }
    }

    /**
     * 获取给定时间月份第一天
     * @param date 时间字符串
     * @param oldFmt 原始日期格式
     * @param newFmt 输出日期格式
     * @return 日期字符串
     */
    public static String getFirstDayOfMonth(String date,String oldFmt,String newFmt){
        Calendar instance = Calendar.getInstance();
        instance.setTime(str2date(date,oldFmt));
        instance.add(Calendar.MONTH,0);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return date2str(instance.getTime(),newFmt);
    }

    /**
     * 获取给定时间月份最后天
     * @param date 时间字符串
     * @param oldFmt 原始日期格式
     * @param newFmt 输出日期格式
     * @return 日期字符串
     */
    public static String getLastDayOfMonth(String date,String oldFmt,String newFmt){
        Calendar instance = Calendar.getInstance();
        instance.setTime(str2date(date,oldFmt));
        instance.add(Calendar.MONTH,1);
        instance.set(Calendar.DAY_OF_MONTH, 0);
        return date2str(instance.getTime(),newFmt);
    }

    /**
     * 获取给定时间是星期几
     * @param date 日期字符串
     * @param fmt 日期原始格式
     * @param type 1：返回汉子，否则返回数字
     * @return 返回星期几
     */
    public static String getWeekOfDate(String date,String fmt,int type){
        Calendar instance = Calendar.getInstance();
        instance.setTime(str2date(date,fmt));
        int i = instance.get(Calendar.DAY_OF_WEEK)-1;
        if(ConstantInt.ONE.getKey().equals(type)){
            String[] weekdays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
            return weekdays[i];
        }else{
            return (i==0? ConstantInt.SEVEN.getKey():i)+"";
        }
    }
}
