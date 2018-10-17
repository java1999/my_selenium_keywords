package com.my.selenium.test;

import com.my.selenium.utils.control.ActionData;
import com.my.selenium.utils.modle.myexcel.PoiExcel;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class PoiExcelTest {
    @Test
    public void test() throws IOException {
        PoiExcel ex = new PoiExcel("test.xlsx", "Search");
        HashMap<String, String>[][] excelData_map = (HashMap<String, String>[][]) ex.getExcelData_map();
        System.out.println(excelData_map[0][0].get("url"));
        System.out.println(ex.getExcelData_arry()[1][1]);
        ActionData ac = new ActionData("test.xlsx", "Search");
        System.out.println(ac.getAlineData(1).get("url"));
    }
}
