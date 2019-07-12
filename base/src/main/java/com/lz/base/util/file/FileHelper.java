package com.lz.base.util.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 文件操作工具类
 * @author lz
 * @create 2019/6/21
 * @since 1.0.0
 */
public class FileHelper {
    public static final String FILE="0";
    public static final String DIR="1";
    private FileHelper(){

    }

    /**
     * 获取目录下的所有文件列表
     * @param path 目录
     * @param fileType 获取文件类型（0：文件，1：目录）
     * @return
     */
    public static List<File> getDirOrFileList(String path,String fileType){
        List<File> fileList=new ArrayList<>();
        getFiles(fileList,path,fileType);
        return fileList;
    }

    /**
     * 文件压缩
     * @param dir 压缩文件目录
     * @param zipFilePath 输出文件全路径（包括文件名）
     * @param regex 压缩文件过滤正则表达式
     * @throws Exception
     */
    public static void zip(String dir,String zipFilePath,String regex) throws IOException{
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFilePath));BufferedOutputStream bo = new BufferedOutputStream(out)){
            File file=new File(dir);
            zip(out, file, file.getName(), bo,regex);
        }
    }

    /**
     * 压缩文件（默认输出路径和压缩文件目录相同）
     * @param dir 压缩文件目录
     * @throws Exception
     */
    public static void zip(String dir) throws IOException{
        zip(dir,dir+".zip",null);
    }

    /**
     * 文件压缩
     * @param dir 压缩文件目录
     * @param zipFilePath 输出文件全路径（包括文件名）
     * @throws Exception
     */
    public static void zip(String dir,String zipFilePath) throws IOException{
        zip(dir,zipFilePath,null);
    }

    /**
     * 文件压缩
     * @param dir 压缩文件目录
     * @param outputStream 输出流
     * @param regex 压缩文件过滤正则表达式
     * @throws Exception
     */
    public static void zip(String dir,OutputStream outputStream,String regex) throws IOException{
        try (ZipOutputStream out = new ZipOutputStream(outputStream);BufferedOutputStream bo = new BufferedOutputStream(out)){
            File file=new File(dir);
            zip(out, file, file.getName(), bo,regex);
        }
    }

    /**
     * 文件压缩
     * @param dir 压缩文件目录
     * @param outputStream 输出流
     * @throws Exception
     */
    public static void zip(String dir,OutputStream outputStream) throws IOException{
        zip(dir,outputStream,null);
    }

    /**
     * 文件压缩
     * @param out 压缩输出流
     * @param inputFile 输入文件或目录
     * @param base 文件或目录名
     * @param bo
     * @throws Exception
     */
    private static void zip(ZipOutputStream out,File inputFile,String base,BufferedOutputStream bo,String regex) throws IOException{
        if (inputFile.isDirectory()) {
            File[] files = inputFile.listFiles();
            if (files.length == 0) {//解决空文件压缩不了问题
                //创建zip压缩进入点base
                out.putNextEntry(new ZipEntry(base + "/"));
            }else{
                for(File file:files){
                    // 递归遍历子文件夹
                    zip(out,file,base + File.separator +file.getName(), bo,regex);
                }
            }
        } else {
            //创建zip压缩进入点base
            if(regex==null || filter(regex,base)){
                out.putNextEntry(new ZipEntry(base));
                try(FileInputStream in = new FileInputStream(inputFile);BufferedInputStream bi = new BufferedInputStream(in)){
                    int b;
                    while ((b = bi.read()) != -1) {
                        // 将字节流写入当前zip目录
                        bo.write(b);
                    }
                }
            }
        }
    }

    /**
     * 解压zip文件
     * @param zipFilePath 压缩文件全路径
     * @param dir 解压后文件路径
     * @param isList 是否获取解压后所有文件列表
     * @return false：返回null，否则返回解压后文件列表
     * @throws IOException
     */
    public static List<File> unZip(String zipFilePath,String dir,boolean isList) throws IOException{
        try (ZipInputStream zin=new ZipInputStream(new FileInputStream(zipFilePath));BufferedInputStream bin=new BufferedInputStream(zin)){
            ZipEntry entry;
            File fOut;
            while((entry=zin.getNextEntry())!=null && !entry.isDirectory()){
                fOut=new File(dir,entry.getName());
                if(!fOut.exists()){
                    (new File(fOut.getParent())).mkdirs();
                }
                try(FileOutputStream out=new FileOutputStream(fOut);BufferedOutputStream bout=new BufferedOutputStream(out)){
                    int b;
                    while((b= bin.read())!=-1){
                        bout.write(b);
                    }
                }
            }
        }
        List<File> list=null;
        if(isList){
            list=getDirOrFileList(dir, FileHelper.FILE);
        }
        return list;
    }


    /**
     * 解压文件
     * @param zipFilePath 压缩文件全路径
     * @param dir 解压后文件目录
     * @throws IOException
     */
    public static void unZip(String zipFilePath,String dir) throws IOException{
        unZip(zipFilePath,dir,false);
    }

    /**
     * 解压zip文件（默认和压缩文件路径相同）
     * @param zipFilePath 压缩文件全路径
     * @throws IOException
     */
    public void unZip(String zipFilePath) throws IOException{
        int index = zipFilePath.lastIndexOf(".zip");
        String parentDir=zipFilePath.substring(0,index);
        unZip(zipFilePath,parentDir);
    }

    /**
     * 迭代遍历目录
     * @param fileList 存放文件或目录的集合
     * @param path 遍历路径
     * @param fileType 获取文件类型（0：文件，1：目录）
     */
    private static void getFiles(List<File> fileList,String path,String fileType){
        File dir=new File(path);
        if(!dir.exists()){
            return;
        }
        File[] files = dir.listFiles();
        for (File file:files){
            if(file.isFile()){
                if(FileHelper.FILE.equals(fileType)){
                    fileList.add(file);
                }
            }else{
                if(FileHelper.DIR.equals(fileType)){
                    fileList.add(file);
                }
                getFiles(fileList,file.getAbsolutePath(),fileType);
            }
        }
    }

    /**
     * 压缩文件过滤
     * @param regex
     * @param content
     * @return
     */
    private static boolean filter(String regex,String content){
        return Pattern.matches(regex,content);
    }

    public static void main(String[] args) throws Exception{
        getDirOrFileList("E:\\myFile\\myproject\\cj\\base\\src\\main\\java\\com\\lz\\base", FileHelper.FILE);
        zip("E:\\myFile\\myproject\\cj\\base\\src\\main\\java\\com\\lz\\base","E:\\base.zip");
        unZip("E:\\base.zip","E:\\aaa");
    }
}
