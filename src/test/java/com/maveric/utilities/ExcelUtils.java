package com.maveric.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFSheet getSheetLevel(String fileNameWithPath,String sheetName) throws IOException
	{
		FileInputStream fileIn=new FileInputStream(fileNameWithPath);
		XSSFWorkbook book=new XSSFWorkbook(fileIn);
		XSSFSheet sheet= book.getSheet(sheetName);
		return sheet;
	}
	
	
	public static XSSFRow getRowLevel(String fileNameWithPath,String sheetName,int rowNumber) throws IOException
	{
		FileInputStream fileIn=new FileInputStream(fileNameWithPath);
		
		XSSFWorkbook book=new XSSFWorkbook(fileIn);
		
		XSSFSheet sheet= book.getSheet(sheetName);
//		XSSFSheet sheet=ExcelUtils.getSheetLevel(fileNameWithPath, sheetName)
		int rowsCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowsCount);		
		XSSFRow row= sheet.getRow(rowNumber);
		
		return row;
	}
	
	public static String getCellValueAsString(String fileNameWithPath,String sheetName,int rowNumber,int cellNumber) throws IOException
	{
		XSSFRow row= ExcelUtils.getRowLevel(fileNameWithPath, sheetName, rowNumber);
		XSSFCell cell= row.getCell(cellNumber);
		DataFormatter format=new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}
	//getcolumnasList
	
	public static Object[][] getSheetAsObjectForDataProvider(String fileNameWithPath,String sheetName) throws IOException
	{
		
		XSSFSheet sheet = ExcelUtils.getSheetLevel(fileNameWithPath, sheetName);
		
		int rowsCount = sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] temp=new Object[rowsCount-1][colCount];
		
		for(int i = 1; i<rowsCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				//System.out.println(i+" "+j);
				XSSFCell cell = sheet.getRow(i).getCell(j);
				DataFormatter format=new DataFormatter();
				String value = format.formatCellValue(cell);
				//System.out.println(value);
				temp[i-1][j]=value;
			}
		}
		
		return temp;
	}
}









