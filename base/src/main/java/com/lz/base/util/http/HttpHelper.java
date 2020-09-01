package com.lz.base.util.http;


import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * http请求工具类
 * @author DELL
 * @create 2020/9/1
 * @since 1.0.0
 */
public class HttpHelper {


    /**
     * 多文件上传
     * @param url 请求路径
     * @param files 附件列表
     * @param fileParam 上传附件参数名
     * @param param 参数列表
     * @return
     */
    @SneakyThrows
    public static String post(String url,List<File> files,String fileParam, Map<String,String> param){
        OkHttpClient client = new OkHttpClient();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        //附件参数
        if(!CollectionUtils.isEmpty(files)){
            files.forEach(file->builder.addFormDataPart(fileParam, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file)));
        }
        //普通参数
        if(!CollectionUtils.isEmpty(param)){
            for (Map.Entry<String,String> entry:param.entrySet()){
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()){
            throw new IOException("Unexpected code " + response);
        }
        return response.body().string();
    }

    /**
     * 多文件上传
     * @param url 请求路径
     * @param files 附件列表
     * @param fileParam 上传附件参数名
     * @return
     */
    @SneakyThrows
    public static String post(String url,List<File> files,String fileParam){
        return post(url, files,fileParam,null);
    }

    /**
     *  单文件上传
     * @param url 请求路径
     * @param file 附件
     * @param fileParam 上传附件参数名
     * @param param 参数列表
     * @return
     */
    public static String post(String url, File file,String fileParam, Map<String,String> param){
        return post(url, Arrays.asList(file),fileParam,param);
    }

    /**
     *  单文件上传
     * @param url 请求路径
     * @param file 附件
     * @param fileParam 上传附件参数名
     * @return
     */
    public static String post(String url, File file,String fileParam){
        return post(url, Arrays.asList(file),fileParam,null);
    }

    /**
     *  参数请求
     * @param url 请求路径
     * @param param 参数列表
     * @return
     */
    public static String post(String url, Map<String,String> param){
        return post(url, Arrays.asList(),null,param);
    }
}
