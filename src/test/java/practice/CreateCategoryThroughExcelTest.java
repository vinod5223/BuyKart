package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCategoryThroughExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Random r= new Random();
		int randomNum=r.nextInt(100);
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet("Sheet2");
		Cell cl=sh.createRow(1).createCell(0);	
		 cl.setCellValue("Clothing");
		String categoryValue=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(categoryValue);
		String CreatedCValue= wb.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		System.out.println(CreatedCValue+""+randomNum);
		
		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\CommonDataForOSA.properties");
		Properties pObj= new Properties();
		pObj.load(fis1);
		
		String URL=pObj.getProperty("admUrl");
		String BROWSER=pObj.getProperty("browser");
		String USERNAME=pObj.getProperty("admUsername");
		String PASSWORD=pObj.getProperty("admPassword");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME, Keys.TAB, PASSWORD, Keys.ENTER);
		driver.findElement(By.xpath("//a[@href='category.php']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter category Name']")).sendKeys(CreatedCValue+""+randomNum);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
	}

}
