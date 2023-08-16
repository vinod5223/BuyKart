package user_Module;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateBillingAndShippingTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();	
//		fetching the data from properties file	
		String BROWSER = fLib.readDataFromPropertiesFile("browser");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");
		String CUST_U_NAME=fLib.readDataFromPropertiesFile("custUsername");
		String CUST_PASSWORD=fLib.readDataFromPropertiesFile("custPassword");		
WebDriver driver= null;	
		if(BROWSER.equalsIgnoreCase("chrome")) {	
			 driver= new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		//login to the application
		driver.get(CUST_URL);
		wLib.waitForPageLoad(driver, 10);
		wLib.maximizeWindow(driver);		
		driver.findElement(By.name("email")).sendKeys(CUST_U_NAME);
		driver.findElement(By.name("password")).sendKeys(CUST_PASSWORD, Keys.ENTER);
		//My account and billing & shipping address
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[@href='bill-ship-addresses.php']")).click();	
		HashMap<String, String> bill= new HashMap<String, String>();
		HashMap<String, String> ship= new HashMap<String, String>();
		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh= wb.getSheet("Bill_Ship");
		JavaUtility jLib= new JavaUtility();
		int ran=jLib.getRandomNo();	
		String billingAddress=sh.getRow(0).getCell(1).getStringCellValue();
		String shippingAddress=sh.getRow(0).getCell(4).getStringCellValue();
		for(int i=1;i<=sh.getLastRowNum();i++) {
			String bill_key=sh.getRow(i).getCell(0).getStringCellValue();
			String bill_value=sh.getRow(i).getCell(1).getStringCellValue();
			bill.put(bill_key, bill_value);
			String ship_key= sh.getRow(i).getCell(3).getStringCellValue();
			String ship_value= sh.getRow(i).getCell(4).getStringCellValue();
			ship.put(ship_key, ship_value);
		}
		System.out.println(bill);
	System.out.println(ship);
		for(Entry<String, String> billmap: bill.entrySet()) {
			WebElement ele=driver.findElement(By.name(billmap.getKey()));
			ele.clear();
			ele.sendKeys(billmap.getValue());
		}
		WebElement billAdd = driver.findElement(By.name("billingaddress"));
		billAdd.clear();
		billAdd.sendKeys(billingAddress+ran);
		driver.findElement(By.name("update")).click();
		Thread.sleep(3000);
		wLib.acceptAlertPopUp(driver);		
		driver.findElement(By.xpath("//a[@href='#collapseTwo']")).click();
		for(Entry<String, String> shipmap:ship.entrySet()) {
			WebElement ele= driver.findElement(By.name(shipmap.getKey()));
			ele.clear();
			ele.sendKeys(shipmap.getValue());	
		}
		WebElement shipAdd = driver.findElement(By.name("shippingaddress"));
		shipAdd.clear();
		shipAdd.sendKeys(shippingAddress+ran);
		driver.findElement(By.name("shipupdate")).click();
		wLib.acceptAlertPopUp(driver);
	}

}













