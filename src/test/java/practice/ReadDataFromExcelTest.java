package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet("Sheet2");
		Cell cl=sh.createRow(1).createCell(0);	
		 cl.setCellValue("Clothing");
//		 FileOutputStream fos= new FileOutputStream();
		String categoryValue=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(categoryValue);
		String CreatedCValue= wb.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		System.out.println(CreatedCValue);
		fis.close();
		System.out.println("excel file closed successfully");
//		C:\Users\USER\OneDrive\Desktop
	}

}
