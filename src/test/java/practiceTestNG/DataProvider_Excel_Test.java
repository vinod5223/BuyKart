package practiceTestNG;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BuyKart.GenericUtility.IPathConstants;

public class DataProvider_Excel_Test {

	@DataProvider
	public Object[][] dataFromExcel() throws Exception{
		FileInputStream fis= new FileInputStream(IPathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Data_Provider");
		int lastRowNum=sh.getLastRowNum();
		System.out.println(lastRowNum);
		
		int lastCellNum= sh.getRow(0).getLastCellNum();
		System.out.println(lastCellNum);
		Object[][] obj= new Object[lastRowNum+1][lastCellNum];
		
		for(int i=0; i<=lastRowNum; i++) {
			for(int j=0;j<lastCellNum;j++) {
				obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		return obj;
	}
	
	@Test(dataProvider = "dataFromExcel")
	public void dpDataFromExcel(String name, String em) {
		System.out.println("name======"+name+"		email======"+em);
	}
	
	
}
