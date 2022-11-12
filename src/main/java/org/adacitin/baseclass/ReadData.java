package org.adacitin.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadData extends CommonUtils{
	
	public static String getConfigPropData(String key) throws IOException {
		File f = new File("./src/main/resources/config.properties");
		FileReader fr = new FileReader(f);
		Properties prop= new Properties();
		prop.load(fr);
		String property = prop.getProperty(key);
		return property;
	}

	public static void readDataFromExcel() throws Exception {
		File f = new File("./src/test/resources/Testdata/readDAta.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
//		// this will get total number of sheet present in wb
//		wb.getNumberOfSheets();
//		//this method will move to the sheet based on the index
//		wb.getSheetAt(0);
		//this method will move to the sheet based on the name
		Sheet sheet = wb.getSheet("overalldata");
		// to get physical number of row in a sheet retutn type is int
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < physicalNumberOfRows; i++) {
			Row row = sheet.getRow(i);
			//to find the number of data present in a row
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < physicalNumberOfCells; j++) {
				Cell cell = row.getCell(j);
				//to check the type of the cell data 
				@SuppressWarnings("deprecation")
				int cellType = cell.getCellType();
				if (cellType==1) {
					// to read the string cell type data from excell
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else if (cellType==0){
					// this is to check the cell is date formated
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						System.out.println(dateCellValue);
						// to change the received system date format as per requirment
						SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
						String format = sdf.format(dateCellValue);
						System.out.println(format);
					}
					else {
						double numericCellValue = cell.getNumericCellValue();
						long l = (long)numericCellValue;
						String valueOf = String.valueOf(l);
						System.out.println(valueOf);
					}
				}
				
			}
			
		}
	}
	
	
	public static String getdatafromexcel(String sheet,int row ,int col) throws Exception {
		File f = new File("./src/test/resources/Testdata/readDAta.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell cell = r.getCell(col);
		int cellType = cell.getCellType();
		String data = null;
		if (cellType==1) {
			// to read the string cell type data from excell
			data = cell.getStringCellValue();
		}
		else if (cellType==0){
			// this is to check the cell is date formated
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				System.out.println(dateCellValue);
				// to change the received system date format as per requirment
				SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
				data = sdf.format(dateCellValue);
			}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long)numericCellValue;
				data = String.valueOf(l);
			}
		}
		
		return data;
		
	}
	
	
	public static void writeDataInExcel() throws Exception {
		File f = new File("./target/testdata.xlsx");
		
		Workbook wb = new XSSFWorkbook();
		Sheet OverallData = wb.createSheet("OverallData");
		Row row = OverallData.createRow(0);
		Cell createCell = row.createCell(0);
		Cell createCell1 = row.createCell(1);
		createCell.setCellValue("shahulhameed@gmail.com");
		createCell1.setCellValue("05/15/2022");
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		System.out.println("completed");
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		writeDataInExcel();
	}
	
	
}
