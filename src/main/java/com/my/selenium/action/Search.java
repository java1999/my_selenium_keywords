package com.my.selenium.action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class Search {

    public void search(HashMap<String, String> data, WebDriver driver) {

        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//找不到element就再给5秒查找
        try {
            WebElement TestWebElement = null;
            String URL = data.get("url");
            String value = data.get("setValue");
            driver.get(URL);

            driver.manage().window().maximize();

            WebElement txtbox = driver.findElement(By.name("wd"));
            txtbox.clear();
            txtbox.sendKeys(value);

            WebElement btn = driver.findElement(By.id("su"));
            btn.click();

//            WebElement TestWebElement = null;
//            String SetObject = data.get("SetObject").trim();
//            String SetObject_by = SetObject.split(";")[0].toString();
//            String SetObject_Desc = SetObject.split(";")[1].toString();
//            if(SetObject_by.length()>0){
//                TestWebElement = driver.findElement(By.id(SetObject_by));
//            }
//            else if(SetObject_Desc.length()>0){
//                TestWebElement = driver.findElement(By.xpath(SetObject_Desc));
//            }
//            if(data.get("SetOperate").equals("sendKeys")){
//                TestWebElement.clear();
//                TestWebElement.sendKeys(data.get("SetValue"));
//            }else if(data.get("SetOperate").equals("click")){
//                TestWebElement.click();
//            }
//            String ExpObject=data.get("ExpectedObject").trim();
//            if(ExpObject.length()>0){
//                String ExpObject_by=ExpObject.split(";")[0].toString();
//                String ExpObject_Desc=ExpObject.split(";")[1].toString();
//                if(ExpObject_by.length()>0){
//                    Assert.assertEquals(driver.findElement(By.id(ExpObject_by)).getText(),data.get("ExpectedData"), getActionString.get(2)+data.get("ID")+"验证结果：");
//                }
//                else if(ExpObject_Desc.length()>0){
//                    Assert.assertEquals(driver.findElement(By.xpath(ExpObject_Desc)).getText(),data.get("ExpectedData"), getActionString.get(2)+data.get("ID")+"验证结果：");
//                }
//            }
//
//            WebDriverDemo.WebSleep(500);
            Thread.sleep(5000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
