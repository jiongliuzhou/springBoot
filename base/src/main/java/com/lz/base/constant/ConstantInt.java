package com.lz.base.constant;

/**
 *  字符串常量类
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
public enum ConstantInt{
    //时间相关的单位转化量
    ONE_THOUSAND(1000),
    SIXTY(60),
    TWENTY_FOUR(24),

    MINUS_ONE(-1),
    ZERO(0),
    ONE(1),
    TWO(2),
    THRE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12),
    TWENTY_EIGHT(28),
    TWENTY_NINE(29),
    THIRTY(30),
    THIRTY_ONE(31),
    ONE_HUNDRED(100),
    FOUR_HUNDRED(400),
    YEAR_365(365),
    YEAR_366(366),
    ;

    private final Integer key;
    private ConstantInt(Integer key){
        this.key=key;
    }

    public Integer getKey(){
        return key;
    }
}
