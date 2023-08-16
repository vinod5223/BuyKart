package practiceTestNG;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.BuyKart.GenericUtility.IPathConstants;

public class DataProvider_Generic {


	public Object[][] getMultipleDataFromExcel(String SheetName) throws Throwable{
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
	Workbook	 wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int lastRowNum=sh.getLastRowNum();
		int lastCellNum= sh.getRow(lastRowNum).getLastCellNum();
		Object[][] obj= new Object[lastRowNum+1][lastCellNum];
		for(int i=0; i<=lastRowNum; i++) {
			for(int j=0;j<lastCellNum;j++) {
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
