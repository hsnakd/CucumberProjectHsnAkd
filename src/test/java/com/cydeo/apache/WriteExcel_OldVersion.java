package com.cydeo.apache;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel_OldVersion {
    @Test
    public void write_to_excel_file() throws IOException {
        // Right click --> Copy Path/Reference --> Path From Content Root
        String filePath = "src/test/java/com/cydeo/apache/ApacheSampleData_OldVersion.xls";

        // to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(filePath);

        // workbook --> sheet --> row --> cell

        // 1- Create a workbook ==> XSSF ==> Xml Spreadsheet Format
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        // 2- We need to get specific sheet from currently opened workbook
        HSSFSheet sheet = workbook.getSheet("Employees");

        //
        HSSFCell salaryCell0 = sheet.getRow(0).createCell(3);
        salaryCell0.setCellValue("Salary");

        HSSFCell salaryCell1 = sheet.getRow(1).createCell(3);
        salaryCell1.setCellValue(20000);

        HSSFCell salaryCell2 = sheet.getRow(2).createCell(3);
        salaryCell2.setCellValue(30000);

        HSSFCell salaryCell3 = sheet.getRow(3).createCell(3);
        salaryCell3.setCellValue(40000);

        HSSFCell salaryCell4 = sheet.getRow(4).createCell(3);
        salaryCell4.setCellValue(50000);


        // TODO: Change Mary's last name to Jones
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")) {
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");
            }
        }


        // open to write to the file    :   FileInputStream --> reading
        // save changes                 :   FileOutputStream --> reading
        FileOutputStream outputStream = new FileOutputStream(filePath);

        // save/write changes to the workbook
        workbook.write(outputStream);


        // close all
        outputStream.close();
        workbook.close();
        fileInputStream.close();

    }
}
