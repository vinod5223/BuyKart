package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartProductsListTest {

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
		
		driver.findElement(By.name("q")).sendKeys("mobiles", Keys.ENTER);
		
		List<WebElement> prods= driver.findElements(By.className("_4rR01T"));
		Iterator<WebElement> otr= prods.iterator();
		int count=prods.size();
		System.out.println(count);
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Pras.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet("vinodRam1");
		
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\Pras.xlsx");
		for(int i=0; i<count;i++) {
			String all = otr.next().getText();
			System.out.println(all);
			sh.createRow(i).createCell(0).setCellValue(all);
			
		}
		wb.write(fos);
	}

}
