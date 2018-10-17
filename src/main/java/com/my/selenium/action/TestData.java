package com.my.selenium.action;

import com.my.selenium.utils.control.ActionData;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.HashMap;

public class TestData {

    private HashMap<String, String> alineData;

    @DataProvider(name = "action")
    public Object[][] Numbers() throws IOException {
        alineData = new ActionData("test.xlsx", "suite").getAlineData(1);//获取suite表中的第一行数据
        ActionData searchData = new ActionData("test.xlsx", alineData.get("action"));
        return searchData.getMapData();
    }

}
