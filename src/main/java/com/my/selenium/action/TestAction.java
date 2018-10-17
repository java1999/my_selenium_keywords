package com.my.selenium.action;

import com.my.selenium.utils.control.ActionData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class TestAction {

    private HashMap<String, String> alineData;
    String packageName = TestAction.class.getPackage().getName();
    private WebDriver driver = null;

    @BeforeClass
    public void setDriver() throws IOException {
        System.setProperty("webdriver.firefox.bin","D:\\tools\\Mozilla Firefox\\firefox.exe");
//        geckodriver.exe下载地址：https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver","D:\\tools\\Mozilla Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
        alineData = new ActionData("test.xlsx", "suite").getAlineData(1);//获取suite表中的第一行数据
    }

    @Test(dataProvider="action", dataProviderClass = TestData.class)
    public void testAction(HashMap<String, String> data) throws IOException {

        try {
            Class<?> myClass = Class.forName(packageName+"."+alineData.get("action"));
            Method method = myClass.getMethod(alineData.get("method"), HashMap.class, WebDriver.class);
            method.invoke(myClass.newInstance(), data, driver);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass
    public void quit() {
        driver.close();
    }
}
