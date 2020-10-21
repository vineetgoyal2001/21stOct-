package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		 
		File src=new File("./TestData/Data.xlsx");
		
		try {
			  FileInputStream	fis = new FileInputStream(src);
			  wb=new XSSFWorkbook(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
			

		
	}
	
	public String getStringData(int sheetIndex,int row,int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(String sheetname,int row,int column) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetname,int row,int column) {
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

}
