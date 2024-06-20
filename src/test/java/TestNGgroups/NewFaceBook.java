package TestNGgroups;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewFaceBook
{
	public static XSSFWorkbook workbook;

		public void Demo1(String ExcelPath) throws IOException
		{
				File f =new File(ExcelPath);
				FileInputStream fis =new FileInputStream(f);
				workbook =new XSSFWorkbook(fis);
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
	
		public String getSheetTestData(int sheetIndex, int row, int cell)
		{
			//focus on specific sheet
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
				
			//focus on specific cell
			XSSFCell cells = sheet.getRow(row).getCell(cell);

			//check which type value is present in cell
			if(cells.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					String  data1 = cells.getStringCellValue();
					return data1;
				}
			else if(cells.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					String data2 =cells.getRawValue();
					return data2;
				}

			return null;
		}	

}