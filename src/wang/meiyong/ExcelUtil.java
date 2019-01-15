package com.wang.meiyong;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wang.post.Common;

public class ExcelUtil {
    static XSSFWorkbook workBook = null;

    public static String read(String filePath, String sheetNum, int rowNum, int cellNum) throws Exception {
        //����һ��XSSFWorkbook
        workBook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = workBook.getSheet(sheetNum);
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.getCell(cellNum);

        String cellValue = cell.getStringCellValue();

        return cellValue;

    }

    //д������
    public static void write(String filePath, String sheetNum, int rowNum, int cellNum, String value) throws Exception {
        workBook = new XSSFWorkbook(new FileInputStream(filePath));
        XSSFSheet sheet = workBook.getSheet(sheetNum);
        XSSFRow row = sheet.getRow(rowNum);
        XSSFCell cell = row.createCell(cellNum);
        cell.setCellValue(value);

        FileOutputStream out = new FileOutputStream(filePath);
        workBook.write(out);
        out.close();
    }


    public static void main(String[] args) throws Exception {
        String str = read("G://test.xlsx", "login", 2, 0);
        String str1 = Common.getJsonString(str, "chanelStyle");
        System.out.println(str1);

        //    	write("G://test.xlsx","login",1,11,"pass");
        System.out.println(str);
    }
}
