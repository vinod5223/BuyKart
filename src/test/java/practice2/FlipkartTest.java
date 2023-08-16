package practice2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("mobile", Keys.ENTER);

driver.findElement(By.xpath("(//span[text()='Add to Compare'])[1]")).click();
driver.findElement(By.xpath("(//span[text()='Add to Compare'])[2]")).click();
Actions act= new Actions(driver);
WebElement compare=driver.findElement(By.xpath("//span[text()='COMPARE']"));
act.moveToElement(compare).perform();

WebElement pro= driver.findElement(By.xpath("//span[text()='✕']"));
act.moveToElement(pro).click().perform();

	
		 }
	
		
	}







//FileInputStream fisu= new FileInputStream(".\\src\\test\\resources\\Pras.xlsx");
//
//Workbook wb=WorkbookFactory.create(fisu);
//Sheet sh= wb.createSheet("Vin123456");
//
//FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Pras.xlsx");
//
//List<WebElement> products=driver.findElements(By.className("_4rR01T"));
//System.out.println(products.size());
// Iterator<WebElement> itr= products.iterator();
// int count = 1;
// while(itr.hasNext() || count<=products.size()) {
//		 String prod= itr.next().getText();
//		 sh.createRow(count).createCell(0).setCellValue(prod);
//		 System.out.println(prod);
//		 count++;
//		 
//	 }
// wb.write(fos);
// System.out.println("done");
// System.out.println(products);












