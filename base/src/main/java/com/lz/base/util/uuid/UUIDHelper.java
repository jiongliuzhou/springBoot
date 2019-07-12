package com.lz.base.util.uuid;

import java.util.UUID;

/**
 * 获取不同长度的uuid工具类(uuid组成：8 + 4 + 4 + 4 + 12)
 * @author lz
 * @create 2019/6/3
 * @since 1.0.0
 */
public class UUIDHelper {
    private UUIDHelper(){

    }
    /**
     * 获取4位uuid
     * @return
     */
    public static String get4UUID(){
        return UUID.randomUUID().toString().split("-")[1];
    }

    /**
     * 获取8位uuid
     * @return
     */
    public static String get8UUID(){
        return UUID.randomUUID().toString().split("-")[0];
    }

    /**
     * 获取12位uuid
     * @return
     */
    public static String get12UUID(){
        return UUID.randomUUID().toString().split("-")[4];
    }

    /**
     * 获取16位uuid
     * @return
     */
    public static String get16UUID(){
        String[] split = UUID.randomUUID().toString().split("-");
        return split[3]+split[4];
    }

    /**
     * 获取20位uuid
     * @return
     */
    public static String get20UUID(){
        String[] split = UUID.randomUUID().toString().split("-");
        return split[0]+split[1]+split[2]+split[3];
    }

    /**
     * 获取24位uuid
     * @return
     */
    public static String get24UUID(){
        String[] split = UUID.randomUUID().toString().split("-");
        return split[0]+split[1]+split[4];
    }

    /**
     * 获取28位uuid
     * @return
     */
    public static String get28UUID(){
        String[] split = UUID.randomUUID().toString().split("-");
        return split[0]+split[1]+split[2]+split[4];
    }

    /**
     * 获取32位uuid
     * @return
     */
    public static String get32UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
