package com.BuyKart.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {

	
	/** this method is used to get the data from the excel file
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String getDataFromExcel(String SheetName, int rowNo, int cellNo) throws Exception, Exception {
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return data;
	}
	
	/**
	 * This method is used to get the data from excel 
	 * It works for fetching integer values also. It formats the integer values into String
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String getDataFromExcelDF(String SheetName, int rowNo, int cellNo) throws Exception, Exception {
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		DataFormatter df= new DataFormatter();
		String data=df.formatCellValue( wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo));
		return data;
	}
	
	
	
	/** This method is used to write the data into excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String data) throws Throwable, IOException {
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream(IPathConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
	
	/** This method is used to get the last row number in an excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		int lastRN=wb.getSheet(sheetName).getLastRowNum();
		return lastRN;
	}
	
	/** This method is used to get Multiple data from the excel sheet in the form of key and values
	 * @param sheetName
	 * @param keyCellNo
	 * @param valueCellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String,String> getMultipleDataFromExcel(WebDriver driver,String sheetName,int keyCellNo, int valueCellNo) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRowNo=sh.getLastRowNum();
		
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=0; i<=lastRowNo;i++) {
			String key= sh.getRow(i).getCell(keyCellNo).getStringCellValue();
			String value= sh.getRow(i).getCell(valueCellNo).getStringCellValue();
			map.put(key, value);
		}
		return map;	
	}
	
	
	public Object[][] getMultipleDataFromExcelByDP(String SheetName) throws Throwable {
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastRowNum=sh.getLastRowNum();
		int lastColNum= sh.getRow(0).getLastCellNum();
		Object[][] obj= new Object[lastRowNum+1][lastColNum];
		
		for(int i=0; i<=lastRowNum; i++) {
			for(int j=0; j<lastColNum;j++) {
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
	}
}
	
	
	
	
	
	
	
	
	
	




















