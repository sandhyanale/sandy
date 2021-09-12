package com.crm.comcast.GenericUtils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelUtility {
	
	public String getExcelData(String sheetName, int rowNum, int cellNum ) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstatnts.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		return value;
}
	
public void getExcelData(String sheetName, String tcId, String headerName) throws Throwable
{
	FileInputStream file=new FileInputStream(IPathConstatnts.EXCELPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetName);
	int lastRowNum = sheet.getLastRowNum();
	int ExpectedRow=0;
	for(int i=0;i<=lastRowNum;i++)
	{
		String testcaseID = sheet.getRow(i).getCell(0).getStringCellValue();
		if(testcaseID.equalsIgnoreCase(tcId))
		{
			ExpectedRow=i;
			break;
		}
	}
	
	
}
}
