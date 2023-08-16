package user_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyingPaymentPageTest {
	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();	
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
	String ProdName="Apple iPhone 6 (Silver, 16 GB)";
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("//div[text()=' Categories']/ancestor::div/descendant::a[@href='category.php?cid=4']")).click();
		driver.findElement(By.xpath("//a[@href='sub-category.php?scid=4']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		WebElement quantity=driver.findElement(By.xpath("//input[@value='1']"));
		quantity.clear();
		quantity.sendKeys("2");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()=' ADD TO CART']")).click();
		wLib.acceptAlertPopUp(driver);
		driver.findElement(By.name("ordersubmit")).click();
String cod=driver.findElement(By.xpath("//input[@name=\"submit\"]/preceding-sibling::input[@value='COD']")).getText();
System.out.println(cod);
String payment=driver.findElement(By.xpath("//form[@name='payment']")).getText();
		System.out.println(payment);
		//getting  the stored payment options text from the UI	
		String COD=eLib.getDataFromExcel("Verify_PaymentOptions", 0, 0);
		String IB=eLib.getDataFromExcel("Verify_PaymentOptions", 1, 0);
		String D_C_Card=eLib.getDataFromExcel("Verify_PaymentOptions", 2, 0);
		if(payment.contains(COD)) {
			System.out.println("cod option is present");
		}
		if(payment.contains(IB)) {
			System.out.println("Internet banking option is present");
		}
		if(payment.contains(D_C_Card)) {
			System.out.println("Debit / Credit Card option is present");
		}	
	}
}
