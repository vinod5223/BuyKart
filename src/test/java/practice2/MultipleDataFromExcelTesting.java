package practice2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.BuyKart.GenericUtility.ExcelUtility;

public class MultipleDataFromExcelTesting {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://portal2.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction?request_locale=en");
		ExcelUtility eUtil= new ExcelUtility();
		eUtil.getMultipleDataFromExcel(driver, "Passport", 0, 1);
	}
}
