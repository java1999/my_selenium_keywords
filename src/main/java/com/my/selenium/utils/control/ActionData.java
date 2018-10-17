package com.my.selenium.utils.control;


import com.my.selenium.utils.modle.myexcel.PoiExcel;

import java.io.IOException;
import java.util.HashMap;

public class ActionData {
    private String fileName;
    private String sheetName;

    public ActionData(String fileName, String sheetName) {
        this.fileName = fileName;
        this.sheetName = sheetName;
    }

    public PoiExcel getPoiExcel() {
        return new PoiExcel(fileName, sheetName);
    }

    public Object[][] getMapData() throws IOException {
        return getPoiExcel().getExcelData_map();
    }

    public Object[][] getArryData() throws IOException {
        return getPoiExcel().getExcelData_arry();
    }

    public HashMap<String, String> getAlineData(int row) throws IOException {
        return ((HashMap<String, String>[][])getMapData())[row - 1][0];
    }

}
