package practice2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteOneDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.createSheet("SheetVinod1234");
	sh.createRow(0).createCell(0).setCellValue("VinodTestToWrite1234");
	FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Practice\\demoBook1.xlsx");
	wb.write(fos);
	System.out.println("succ");	
	
	}

}
