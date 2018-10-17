package com.my.selenium.utils.modle.propertie;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *  读取配置文件的内容
 * @author Admin
 *
 */
public class PropertiesFile {

    public static String read(String key) {
        Properties pps = new Properties();
        BufferedInputStream in = null;
        try {
            // 读取config文件
            File file = new File("./src/main/resources/properties/Config.properties");
            in = new BufferedInputStream(new FileInputStream(file));
            pps.load(in);// 加载属性列表

            if (pps.containsKey(key)) {
                String value = pps.getProperty(key);
                return value; // 返回读取的内容
            } else {
                System.out.println("没有读取到"+key);
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        PropertiesFile pf = new PropertiesFile();
        String ss = pf.read("user");
        System.out.println(ss);
    }
}
