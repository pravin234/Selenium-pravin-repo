package TestNgDataDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
public static XSSFWorkbook workbook;
	
	public ExcelReader(String excelPath) throws IOException
	{
		File f = new File(excelPath);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
	}
	
	public int getTotalRowCount(int sheetIndex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int rows = sheet.getLastRowNum()+1;
		return rows;
		
	}
	
	public int getTotalColumnCount(int sheetIndex)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		int cells = sheet.getRow(0).getLastCellNum();
		return cells;
	}
	
	public Object getSheetTestData(int sheetIndex, int row, int cell)
	{
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		XSSFCell cells = sheet.getRow(row).getCell(cell);
		
		if(cells.getCellType()== XSSFCell.CELL_TYPE_BLANK)
		{
			return "";
		}
		
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_STRING)
		{
			return cells.getStringCellValue();
		}
		
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		{
			return cells.getRawValue();
		}
		
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN)
		{
			return cells.getBooleanCellValue();
		}
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_FORMULA)
		{
			return cells.getCellFormula();
		}
		return null;
	}
	
	public Object[][] getAllSheetTestData(int sheetIndex)
	{
		int rows = getTotalRowCount(sheetIndex);
		int cells = getTotalColumnCount(sheetIndex);
		
		Object [][] data = new Object[rows][cells];
		
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j<cells; j++)
			{
				data[i][j]= getSheetTestData(sheetIndex, i, j);
			}
		}
		return data;
	}

}
