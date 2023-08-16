package practice2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MulDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
			Sheet sh= wb.getSheet("Sheet2");
			Row rw= sh.getRow(0);
			for(int i=0; i<=sh.getLastRowNum();i++) {
				for(int j=0; j<rw.getLastCellNum();j++) {
					String data	=sh.getRow(i).getCell(j).getStringCellValue();
					System.out.print(data+" ");
				}
				System.out.println();
				
			}
	}

}
