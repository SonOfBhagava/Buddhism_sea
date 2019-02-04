package com.bhagava.common.utils;

import java.io.*;

/**
 * @Auther: FeiJunhao
 * @Date: 2019/1/25 14:27
 * @Description: 用于文件读写操作的工具类
 */
public class FileIOUtil {

    /**
     * 根据文件名读取文本中所有类容
     * @param fileName 带有绝对路径的完整文件名
     * @return 读取的所有文本内容，如果文件不存会返回提示信息
     */
    public static String readFileByAll(String fileName){
        String fileContent = "";
        try {
            File f = new File(fileName);
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(f), "gbk");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent += line+"\n";
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContent;
    }


    /**
     * 一行一行读取文件，解决读取中文字符时出现乱码
     * @param fileName 带有绝对路径的完整文件名
     * @throws IOException
     */
    public static void readFileByLine (String fileName) throws IOException {
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
        String[] arrs = null;
        while ((line = br.readLine())!=null) {
            System.out.println(line + "请在循环中做你想做的操作");
        }
        br.close();
        isr.close();
        fis.close();
    }


    /**
     * 向文件中写入数据，如果文件不存在，就根据路径名新建一个文件
     * @param content 要写入的内容
     * @param fileName 带有绝对路径的完整文件名
     * @param isAppend 是否追加
     */
    public static boolean writeFile(String content,String fileName,boolean isAppend) {
        FileWriter fw = null;
        File f = new File(fileName);
        if(!f.exists())
        {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f,isAppend);
            pw = new PrintWriter(fw);
            pw.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                pw.flush();
                fw.flush();
                pw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    /**
     * 清空文本内容
     * @param fileName 带有绝对路径的完整文件名
     * @return
     */
    public static boolean cleanFile(String fileName){
        File file =new File(fileName);
        try {
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 清除文本中的符号
     * @param str
     * @return
     */
    public static String cleanSymbol(String str){
        str = str.replace(" ","")
                .replace("，","")
                .replace("。","")
                .replace("‘","")
                .replace("’","")
                .replace("“","")
                .replace("”","")
                .replace("？","")
                .replace("：","")
                .replace("《","")
                .replace("》","")
                .replace("　","")
                .replace("\n","")
                .replace("、","")
                .replace("\"","")
                .replace("?","")
                .replace("-","")
                .replace(";","")
                .replace("；","")
                .replace("！","");
        return str;
    }

    public static void main(String[] args) {


    }


}
