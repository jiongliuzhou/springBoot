package com.lz.base.util.base;
import com.lz.base.constant.ConstantStr;
import lombok.Data;

/**
 * 返回结果处理类
 * @create 2019/5/21
 * @since 1.0.0
 */
@Data
public class ResultInvoke<T> {
    /**
     * 返回结果码（0：成功，1：失败）
     */
    private String code;
    /**
     * 返回结果消息提示
     */
    private String msg;
    /**
     * 业务数据
     */
    private T data;

    private ResultInvoke(){}

    private ResultInvoke(String code, String msg){
        this.code=code;
        this.msg=msg;
    }

    private ResultInvoke(String code, String msg, T t){
        this.code=code;
        this.msg=msg;
        this.data=t;
    }

    /**
     * 操作成功
     * @param <T>
     * @return
     */
    public static<T> ResultInvoke<T> success(){
        return new ResultInvoke<>(ConstantStr.SUCCESS_CODE.getKey(), ConstantStr.SUCCESS.getKey());
    }

    public static<T> ResultInvoke<T> success(T t){
        return new ResultInvoke<>(ConstantStr.SUCCESS_CODE.getKey(), ConstantStr.SUCCESS.getKey(),t);
    }

    public static<T> ResultInvoke<T> success(T t, String msg){
        return new ResultInvoke<>(ConstantStr.SUCCESS_CODE.getKey(),msg,t);
    }

    public static<T> ResultInvoke<T> success(T t, String code, String msg){
        return new ResultInvoke<>(code,msg,t);
    }

    /**
     * 操作失败
     * @param <T>
     * @return
     */
    public static<T> ResultInvoke<T> fail(){
        return new ResultInvoke<>(ConstantStr.FAIL_CODE.getKey(), ConstantStr.FAIL.getKey());
    }

    public static<T> ResultInvoke<T> fail(String msg){
        return new ResultInvoke<>(ConstantStr.FAIL_CODE.getKey(),msg);
    }

    public static<T> ResultInvoke<T> fail(String code, String msg){
        return new ResultInvoke<>(code,msg);
    }
}
