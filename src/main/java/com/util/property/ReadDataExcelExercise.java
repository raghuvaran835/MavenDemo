package com.util.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcelExercise {
	public String getValue(String data) throws IOException
	{
		String sheetName=data.split(" ")[0];
		String key=data.split(" ")[1];
		FileInputStream fi=new FileInputStream("C:\\Users\\raghuvr\\Documents\\Eclipse_Workspace\\MavenDemo\\src\\test\\resources\\Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet(sheetName);
		Iterator<Row> rows=sh.iterator();
		String value = null;
		while(rows.hasNext())
		{
			Row row=rows.next();
			
			if(row.getCell(0).getStringCellValue().equals(key))
			{
				Cell cell=row.getCell(1);
				if(cell.getCellType()==CellType.STRING)
				{
					value=cell.getStringCellValue();
				}
				else {
					value=NumberToTextConverter.toText(cell.getNumericCellValue());
				}
			}
			
		}
		return value;
		
		
		
		
		
	}

}
