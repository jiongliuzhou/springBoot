package com.lz.authentication.util;

/**
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
public enum  Constants {
    SYS_USER("SYS_USER"),
    SYS_ROLE("SYS_ROLE"),
    SYS_PERMISSION("SYS_PERMISSION"),
    SYS_RESOURCE("SYS_RESOURCE"),
    SYS_USER_ROLE("SYS_USER_ROLE"),
    SYS_ROLE_PERMISSION("SYS_ROLE_PERMISSION"),
    SYS_PERMISSION_RESOURCE("SYS_PERMISSION_RESOURCE"),
    ;


    private String key;
    private Constants(String key){
        this.key=key;
    }

    public String getKey(){
        return key;
    }

}
