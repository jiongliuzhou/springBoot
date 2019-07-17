package com.lz.base.util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author lz
 * @create 2019/7/17
 * @since 1.0.0
 */
public class ExceptionHelper {
    private ExceptionHelper(){

    }
    /**
     * 处理程序异常返回信息
     * @param e
     * @return
     */
    public static String dealException(Exception e){
        String message;
        try(StringWriter sw = new StringWriter(); PrintWriter pw=new PrintWriter(sw)){
            e.printStackTrace(pw);
            message=sw.toString();
        }catch (Exception e1){
            message=e1.getMessage();
        }
        return message;
    }
}
