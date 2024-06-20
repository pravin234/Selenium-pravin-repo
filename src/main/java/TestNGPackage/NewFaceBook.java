package TestNGPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewFaceBook
{
	public static XSSFWorkbook workbook;
//
//	public Demo1(String excelPath) throws Exception {
//		// step 1:: check file is present or not by creating object of File class and by
//		// passing
//		// file location
//		File f = new File(excelPath);
//		// step 2:: read all file content by creating object of FileInputStream and by
//		// passing File class Instance
//		FileInputStream fis = new FileInputStream(f);
//		// step 3: load the all work sheet by creating object of XSSFWorkbook and by
//		// passing FileInputStream instance
//		workbook = new XSSFWorkbook(fis);
//	}
	
	//create non static method with 1 int arguments and int return type
	public int getTotalRowCount(int sheetIndex)
	{
		//step 1: focus on specific sheet
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		//step 2: capture the total rows in sheet
		int rows = sheet.getLastRowNum()+1;
		//step 3: return the capture rows
		return rows;
	}
	
	//create non static method with 1 int arguments and int return type
	public int getTotalColumnCount(int sheetIndex)
	{
		//step 1: focus on specific sheet
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		
		//step 2: capture total columns in sheet by focusing on row 1 
		int cells = sheet.getRow(0).getLastCellNum();
		
		//step 3: return the capture cells or columns
		return cells;
	}
	
	//create non static method with 3 int arguments and Object return type
	public Object getSheetTestData(int sheetIndex, int row, int cell)
	{
		//step 1: focus on specific sheet
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		
		//step 2: focus on specific cell
		XSSFCell cells = sheet.getRow(row).getCell(cell);
		
		//Step 3: check which type of value is present inside the cell
		//if cell is blank then return blank space
		if(cells.getCellType()== XSSFCell.CELL_TYPE_BLANK)
		{
			return "";
		}
		//if cell value type is String then return the String value
		else if(cells.getCellType() == XSSFCell.CELL_TYPE_STRING)
		{
			//Step 4: capture the String cell value
			String a = cells.getStringCellValue();
			return a;
		}
		//if cell value type is numeric then return the numeric value
		else if(cells.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
		{
			//step 5: capture the numeric cell value
			String b = cells.getRawValue();
			return b;
		}
		//if cell value type is boolean then return the boolean value
		else if(cells.getCellType()== XSSFCell.CELL_TYPE_BOOLEAN)
		{
			boolean c = cells.getBooleanCellValue();
			return c;
		}
		//if cell value type is formula then return the formula value
		else if(cells.getCellType() == XSSFCell.CELL_TYPE_FORMULA)
		{
			String d = cells.getCellFormula();
			return d;
		}
		
		//if above values are not matches then return the null.
		return null;
	}

}