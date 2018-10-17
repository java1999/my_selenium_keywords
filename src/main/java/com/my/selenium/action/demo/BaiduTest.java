package com.my.selenium.action.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiduTest {

    private WebDriver driver = null;
    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.firefox.bin","D:\\tools\\Mozilla Firefox\\firefox.exe");
//        geckodriver.exe下载地址：https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver","D:\\tools\\Mozilla Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test(dataProvider = "GetDataFromXml", dataProviderClass = ExcelDataProvider.class)
    public void test1(String URL, String context) {

        driver.get(URL);

        driver.manage().window().maximize();

        WebElement txtbox = driver.findElement(By.name("wd"));
        txtbox.clear();
        txtbox.sendKeys(context);

        WebElement btn = driver.findElement(By.id("su"));
        btn.click();

    }

    @AfterClass
    public void quit() {
        driver.close();
    }

}
