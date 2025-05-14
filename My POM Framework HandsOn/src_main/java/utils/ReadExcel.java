package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String filename) throws IOException {
		
		//To open the workbook
		XSSFWorkbook wb=new XSSFWorkbook("./Data/"+filename+".xlsx");
		
        //Locate the worksheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		//To count the number of rows
		//without header
		int rowCount = ws.getLastRowNum();
		System.out.println("The row count is: "+rowCount);
		
		//To count with header
		int physicalNumberOfRows = ws.getPhysicalNumberOfRows();
		//System.out.println(physicalNumberOfRows);
		
		//To count the column
		int columnCount = ws.getRow(0).getLastCellNum();
		System.out.println("The Column Count is: "+columnCount);
		
		//To retrieve the data
		String row1Cell1Data = ws.getRow(1).getCell(1).getStringCellValue();
		System.out.println("The data is:"+row1Cell1Data);
		
		
		//To retrieve the entire data
		String[][] data=new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
		XSSFRow row = ws.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				String allData = row.getCell(j).getStringCellValue();
				// String allData =row(1).getCell(2).getStringCellValue
				data[i-1][j]=allData;    
			    System.out.println("All data are: "+allData);
				}
			}
		wb.close();
		return data;
		}
}
