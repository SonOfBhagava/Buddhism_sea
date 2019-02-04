package com.bhagava.common.utils;

import com.sun.org.apache.xerces.internal.xinclude.XInclude11TextReader;

import java.io.IOException;
import java.util.Properties;

/**
 * created by FeiJunhao on ${date}
 */
public class Constants {
    public static final String AMITUOJING;
    public static final String XINJING;
    public static final String YAOSHIJING;
    public static final String JINGANGJING;
    public static final String PUMENPIN;
    public static final String BEIFEN;
    static{
        String baseUrl = System.getProperty("user.dir");
        baseUrl = baseUrl.replace("\\","/");

        Properties props = new Properties();
        try {
            props.load(Constants.class.getClassLoader().getResourceAsStream("profiles.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        AMITUOJING = baseUrl + "/common/src/main/resources/wisdom/amituojing.txt";
        XINJING = baseUrl + "/common/src/main/resources/wisdom/xinjing.txt";
        YAOSHIJING = baseUrl + "/common/src/main/resources/wisdom/yaoshijing.txt";
        JINGANGJING = baseUrl + "/common/src/main/resources/wisdom/jingangjing.txt";
        PUMENPIN = baseUrl + "/common/src/main/resources/wisdom/pumenpin.txt";
        BEIFEN = baseUrl + "/common/src/main/resources/wisdom/beifen.txt";
/*        PUMENPIN = props.getProperty("PUMENPIN");*/
    }

    public static void main(String[] args) {

    }
}
