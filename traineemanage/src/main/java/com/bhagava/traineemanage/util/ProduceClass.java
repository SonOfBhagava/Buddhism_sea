package com.bhagava.traineemanage.util;

import com.bhagava.common.utils.FileIOUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * created by FeiJunhao on ${date}
 */
public class ProduceClass {
    public static void produceService(String mapperUrl,String serviceUrl){
        String baseUrl = System.getProperty("user.dir");
        String url = baseUrl + mapperUrl;
        File baseFile = new File(url);
        File[] files = baseFile.listFiles();
        System.out.println(files.length);
        for (int i = 0; i < files.length; i++) {
            try {
                readFileByLine(files[i].getPath(),serviceUrl,true);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * 一行一行读取文件，解决读取中文字符时出现乱码
     * @param fileName 带有绝对路径的完整文件名
     * @param isCover 是否覆盖原文件
     * @throws IOException
     */
    public static void readFileByLine (String fileName,String serviceUrl,boolean isCover) throws IOException {
        File mapper = new File(fileName);
        System.out.println(fileName);
        FileInputStream fis =  null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(fileName);
            isr = new InputStreamReader(fis, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        //创建service
        File serviceFile = getNewFile(System.getProperty("user.dir") + serviceUrl + "/" + mapper.getName().replace("Mapper","Service"),isCover);
        //创建serviceImpl
        File serviceImplFile = getNewFile(System.getProperty("user.dir") + serviceUrl + "/impl" + "/" + mapper.getName().replace("Mapper","ServiceImpl"),isCover);
        while ((line = br.readLine()) != null) {
            if(line.indexOf("package") != -1){
                FileIOUtil.writeFile(line.replace("mapper","service"),serviceFile.getPath(),true);
                FileIOUtil.writeFile(line.replace("mapper","serviceImpl"),serviceImplFile.getPath(),true);
                continue;
            }
            if(line.indexOf("import") != -1){
                FileIOUtil.writeFile(line,serviceFile.getPath(),true);
                FileIOUtil.writeFile(line,serviceImplFile.getPath(),true);
                continue;
            }
            if(line.indexOf("@") != -1){
                FileIOUtil.writeFile("import org.springframework.beans.factory.annotation.Autowired;",serviceImplFile.getPath(),true);
//                FileIOUtil.writeFile("@Mapper",serviceImplFile.getPath(),true);
                FileIOUtil.writeFile("@Service",serviceImplFile.getPath(),true);
                continue;
            }
            if(line.length() == 0){
                FileIOUtil.writeFile(line,serviceFile.getPath(),true);
                FileIOUtil.writeFile(line,serviceImplFile.getPath(),true);
                continue;
            }
            if(line.indexOf("public") != -1){
                FileIOUtil.writeFile(line.replace("Mapper","Service"),serviceFile.getPath(),true);
                FileIOUtil.writeFile(line.replace("Mapper","ServiceImpl").replace("interface","class"),serviceImplFile.getPath(),true);
                FileIOUtil.writeFile(line.replace("@Autowired","ServiceImpl"),serviceImplFile.getPath(),true);
                continue;
            }
            if(line.indexOf("}")== 1){
                FileIOUtil.writeFile(line,serviceFile.getPath(),true);
                FileIOUtil.writeFile(line,serviceImplFile.getPath(),true);
                continue;
            }

            FileIOUtil.writeFile(line,serviceFile.getPath(),true);
            FileIOUtil.writeFile("    @Override",serviceImplFile.getPath(),true);
            FileIOUtil.writeFile(line.replace(";","{ return  }"),serviceImplFile.getPath(),true);
        }
        br.close();
        isr.close();
        fis.close();
    }

    /**
     * 是否覆盖
     * @param url
     * @param isCover
     * @return
     */
    public static File getNewFile(String url,boolean isCover){
        File serviceFile = new File(url);
        if(!serviceFile.exists()){
            try {
                serviceFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            if(isCover){
                serviceFile.delete();
                try {
                    serviceFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return serviceFile;
    }
    public static void main(String[] args) {
        produceService("/traineemanage/src/main/java/com/bhagava/traineemanage/mapper","/traineemanage/src/main/java/com/bhagava/traineemanage/service");
    }
}
