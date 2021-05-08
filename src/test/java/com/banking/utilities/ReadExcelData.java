package com.banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;

	public ReadExcelData(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
	}

	public int getRowCount() {

		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	public int getColCount() {
		row = sheet.getRow(1);
		int colCount = row.getLastCellNum();
		return colCount;

	}

	public String getCellData(int rowNum, int colNum) {
		
		if(CellType.STRING==sheet.getRow(rowNum).getCell(colNum).getCellType()) {
			String data=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			return data;
		}
		else {
			long data=(long)sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			return String.valueOf(data);
		}

	}

	
	/*  public static void main(String[] args) throws IOException {
	  
	  ReadExcelData red=new ReadExcelData(
	  "B:\\finalProjects\\Hybrid_Data_Keyword_driven_framework\\src\\test\\resources\\excel\\customerData.xlsx",
	  "regData");
	  
	  System.out.println(red.getCellData(1, 0));
	  System.out.println(red.getCellData(1, 1));
	  System.out.println(red.getCellData(1, 2));
	  System.out.println(red.getCellData(1, 3));
	  System.out.println(red.getCellData(1, 4));
	  System.out.println(red.getCellData(1, 5));
	  System.out.println(red.getCellData(1, 6));
	  System.out.println(red.getCellData(1, 7));
	  System.out.println(red.getCellData(1, 8));
	  System.out.println(red.getCellData(1, 9));
	  
	  
	  
	  }*/
	 

}
