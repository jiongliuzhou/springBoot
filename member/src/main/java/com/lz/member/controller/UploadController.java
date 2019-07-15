package com.lz.member.controller;

import com.lz.base.util.upload.UploadHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传
 * @author lz
 * @create 2019/6/5
 * @since 1.0.0
 */
@Controller
@RequestMapping("/uploadController")
public class UploadController {
    @Resource
    private UploadHelper uploadHelper;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public Object uploadFile(@RequestParam("file") MultipartFile file){
        return uploadHelper.fileUpload(file);
    }

    /**
     * 文件下载
     * @param response
     * @param file
     */
    @RequestMapping("/download")
    @ResponseBody
    public Object download(HttpServletResponse response, String file){
        return uploadHelper.downloadFile(response,file);
    }
}
