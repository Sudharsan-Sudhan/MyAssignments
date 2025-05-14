package week6.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSFA {


	public static String[][] readData() throws IOException {
		
		//To open the workbook
		XSSFWorkbook wrkbk = new XSSFWorkbook("./Data/CreateLegalEntity.xlsx");
		
        //Locate the worksheet
		XSSFSheet wrksht = wrkbk.getSheet("Sheet1");
		
		//To count the number of rows without header
		int rowCount = wrksht.getLastRowNum();
		System.out.println("The row count is: "+rowCount);
		
		//To count with header
		int physicalNumberOfRows = wrksht.getPhysicalNumberOfRows();
		//System.out.println(physicalNumberOfRows);
		
		//To count the column
		int columnCount = wrksht.getRow(0).getLastCellNum();
		System.out.println("The Column Count is: "+columnCount);
		
		//To retrieve the data
		String row1Cell1Data = wrksht.getRow(1).getCell(1).getStringCellValue();
		System.out.println("The data is:"+row1Cell1Data);
		
		//To retrieve the entire data
		String[][] data=new String[rowCount][columnCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = wrksht.getRow(i);
		
			for (int j = 0; j < columnCount; j++) {
				String allData = row.getCell(j).getStringCellValue();
				data[i-1][j]=allData;    
			    System.out.println("All data are: "+allData);
				}
			}
		wrkbk.close();
		return data;
		}

}