package com.lz.base.constant;

/**
 *  字符串常量类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
public enum ConstantStr {
    //controller层需要的操作字符串
    SUCCESS_CODE("1"),
    SUCCESS("操作成功"),
    FAIL_CODE("0"),
    FAIL("操作失败"),

    //时间相关的字符串格式
    FMT("yyyy"),
    FMT_1("MM"),
    FMT_2("dd"),
    FMT_3("HH"),
    FMT_4("mm"),
    FMT_5("ss"),
    FMT_6("milli"),

    FMT1("yyyyMMddHHmmss"),
    FMT1_1("yyyyMMdd"),
    FMT1_2("yyyyMM"),

    FMT2("yyyy-MM-dd HH:mm:ss"),
    FMT2_1("yyyy-MM-dd HH:mm"),
    FMT2_2("yyyy-MM-dd"),
    FMT2_3("yyyy-MM"),
    FMT2_4("HH:mm:ss"),
    FMT2_5("HH:mm"),

    FMT3("yyyy年MM月dd日HH时mm分ss秒"),
    FMT3_1("yyyy年MM月dd日HH时mm分"),
    FMT3_2("yyyy年MM月dd日HH时"),
    FMT3_3("yyyy年MM月dd日"),
    FMT3_4("yyyy年MM月"),
    FMT3_5("yyyy年"),
    FMT3_6("HH时mm分ss秒"),
    FMT3_7("HH时mm分"),
    ;

    private final String key;
    private ConstantStr(String key){
        this.key=key;
    }

    public String getKey(){
        return key;
    }
}
