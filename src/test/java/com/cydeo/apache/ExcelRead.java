package com.cydeo.apache;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    @Test
    public void read_from_excel_file() throws IOException {
        // Right click --> Copy Path/Reference --> Path From Content Root
        String filePath = "src/test/java/com/cydeo/apache/ApacheSampleData.xlsx";

        // to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(filePath);

        // workbook --> sheet --> row --> cell

        // 1- Create a workbook ==> XSSF ==> Xml Spreadsheet Format
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 2- We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // 3- Select row and cell ==> Print out Mary's cell ==> Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        // Return the count of used cells only --> Starts counting from 1
        int usedRows =  sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        // Return the number from top cell to bottom cell
        // It doesn't care is the cell is empty or not --> Starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        // TODO: Create a logic to print Vinod's name

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println("sheet.getRow(rowNum).getCell(0) = " + sheet.getRow(rowNum).getCell(0));
            }
        }

        // TODO: Create a logic to print Linda's JOB_ID
        // Check if name is Linda --> print out JOB_ID of Linda

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println("sheet.getRow(rowNum).getCell(2) = " + sheet.getRow(rowNum).getCell(2));
            }
        }
    }
}
