package com.util.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
public ArrayList<String> getData(String testName) throws IOException
{
	ArrayList<String> getDataValue= new ArrayList<String>();
	FileInputStream fi=new FileInputStream("C:\\Users\\raghuvr\\Documents\\Eclipse_Workspace\\MavenDemo\\src\\test\\resources\\Data.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet sh=wb.getSheet("Data");
	Iterator<Row> rows= sh.iterator();
	Row firstRow = rows.next();  // Row 1
	int col=0;
	int k=0;
	Iterator<Cell> cells=firstRow.iterator(); 
	while(cells.hasNext()) {
		Cell cellValue= cells.next();
		if(cellValue.getStringCellValue().equals("TestName")) {
			col=k;
		}
		k++;
	}
	while(rows.hasNext()) {
		Row rw= rows.next();   //2nd Row
		
		if(rw.getCell(col).getStringCellValue().equals(testName)) {
			Iterator<Cell> cellV=rw.iterator();
			while(cellV.hasNext()) {
				Cell c=cellV.next();
				if(c.getCellType()==CellType.STRING)
					getDataValue.add(c.getStringCellValue());
				else						
					getDataValue.add(NumberToTextConverter.toText(c.getNumericCellValue()));
			}
		}
	}
	
	return getDataValue;
}
}
