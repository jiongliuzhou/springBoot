package com.lz.base.util.upload;

import com.lz.base.util.base.ResultInvoke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 文件上传、下载
 * @author lz
 * @create 2019/6/5
 * @since 1.0.0
 */
@Component
@PropertySource("classpath:config.properties")
@Slf4j
public class UploadHelper {
    @Value("${file.upload.path}")
    private String path;

    /**
     * 单文件上传
     * @param file
     * @param path 文件路径
     * @return
     */
    public Object fileUpload(MultipartFile file,String path){
        Object obj;
        if(file.isEmpty()){
            obj= ResultInvoke.fail();
        }else{
            String fileName = file.getOriginalFilename();
            String filePath=path+fileName;
            File dest=new File(filePath);
            //判断目录是否存在，不存在就创建
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try {
                //保存文件
                file.transferTo(dest);
                obj=ResultInvoke.success();
            }catch (Exception e){
                obj=ResultInvoke.fail(e.getMessage());
            }
        }
        return obj;
    }

    /**
     * 单文件上传
     * @param file
     * @return
     */
    public Object fileUpload(MultipartFile file){
        return fileUpload(file,path);
    }

    /**
     * 多文件上传
     * @param request
     * @param name 表单属性名称
     * @param path 上传文件路径
     * @return
     */
    public Object multiFileUpload(HttpServletRequest request,String name,String path){
        Object obj;
        try {
            List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles(name);
            for(MultipartFile file:files){
                fileUpload(file,path);
            }
            obj=ResultInvoke.success();
        }catch (Exception e){
            obj=ResultInvoke.fail(e.getMessage());
        }
        return obj;
    }

    /**
     * 文件下载
     * @param response
     * @param filePath 文件完整路径
     * @param fileName 文件名称
     */
    public Object downloadFile(HttpServletResponse response, String filePath,String fileName){
        Object obj=null;
        File file=new File(filePath);
        if(file.exists()){
            try (FileInputStream in=new FileInputStream(file);BufferedInputStream bin=new BufferedInputStream(in)){
                response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(fileName,"utf-8"));
                ServletOutputStream outputStream = response.getOutputStream();
                byte[] buffer = new byte[1024];
                int i=bin.read(buffer);
                while (i!=-1){
                    outputStream.write(buffer);
                    i=bin.read(buffer);
                }
                outputStream.flush();
                outputStream.close();
            }catch (Exception e){
                obj=ResultInvoke.fail(e.getMessage());
            }
        }else{
            obj=ResultInvoke.fail("文件不存在");
        }
        return obj;
    }

    /**
     * 文件下载
     * @param response
     * @param fileName 文件名称
     */
    public Object downloadFile(HttpServletResponse response,String fileName){
        return downloadFile(response,path+fileName,fileName);
    }
}
