package com.my.selenium.utils.modle.myexcel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class PoiExcel {
    private String fileName;
    private String sheetName;
    private XSSFSheet ExcelSheet;
    private XSSFWorkbook ExcelBook;
    private XSSFRow Row;
    private XSSFCell Cell;
    private String defaultPath;

    public PoiExcel(String fileName, String sheetName) {
        this.fileName = fileName;
        this.sheetName = sheetName;
    }

    public void setExcel() throws IOException {
        defaultPath = System.getProperty("user.dir") + "\\src\\main\\resources\\xlsx\\" + fileName;
        ExcelBook = new XSSFWorkbook(new FileInputStream(defaultPath));
        ExcelSheet = ExcelBook.getSheet(sheetName);
    }

    public String getCellDate(int RowNum,int CloNum) throws IOException {
        setExcel();
        Cell = ExcelSheet.getRow(RowNum).getCell(CloNum);
        //设置单元格类型
        Cell.setCellType(CellType.STRING);
        String cellData = Cell.getStringCellValue();
        return cellData;
    }

    public void setCellData(String Result, int RowNum, int ColNum) throws Exception{
        setExcel();
        Row = ExcelSheet.getRow(RowNum);
        Cell = Row.getCell(ColNum);
        if (Cell == null) {
            Cell = Row.createCell(ColNum);
            Cell.setCellValue(Result);
        } else {
            Cell.setCellValue(Result);
        }
        FileOutputStream fileOut = new FileOutputStream(defaultPath);
        ExcelBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    /**
     * 获得excel表中的数据
     */
    public Object[][] getExcelData_map() throws IOException {
        setExcel();
        //获取总列数
        int columns = ExcelSheet.getRow(0).getPhysicalNumberOfCells();
        //获得总行数
        int rows = ExcelSheet.getPhysicalNumberOfRows();
        // 为了返回值是Object[][],定义一个多行单列的二维数组
        @SuppressWarnings("unchecked")
        HashMap<String, String>[][] arrmap = new HashMap[rows - 1][1];
        // 对数组中所有元素hashmap进行初始化
        if (rows >= 1) {
            for (int i = 0; i < rows - 1; i++) {
                arrmap[i][0] = new HashMap<String, String>();
            }
        } else {
            System.out.println("excel表中没有数据");
        }
        String[] key = new String[columns];
        // 获得首行的列名，作为hashmap的key值
        for (int c = 0; c < columns; c++) {
            String cellvalue = getCellDate(0, c);
            key[c] = cellvalue;
        }
        // 遍历所有的单元格的值添加到hashmap中
        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                String cellvalue = getCellDate(r, c);
                arrmap[r - 1][0].put(key[c], cellvalue);
            }
        }
        return arrmap;
    }

    /**
     * 获得excel表中的数据
     */
    public Object[][] getExcelData_arry() throws IOException {
        setExcel();
        //获取总列数
        int columns = ExcelSheet.getRow(0).getPhysicalNumberOfCells();
        //获得总行数
        int rows = ExcelSheet.getPhysicalNumberOfRows();

        Object[][] o = new Object[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                o[r][c] = getCellDate(r, c);
            }
        }
        return o;
    }

}