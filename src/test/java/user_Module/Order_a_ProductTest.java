package user_Module;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Order_a_ProductTest {

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
		Alert alt3= driver.switchTo().alert();
		alt3.accept();
		driver.findElement(By.name("ordersubmit")).click();	
String cod=driver.findElement(By.xpath("//input[@name=\"submit\"]/preceding-sibling::input[@value='COD']")).getText();
System.out.println(cod);
String payment=driver.findElement(By.xpath("//form[@name='payment']")).getText();
		System.out.println(payment);	
//		driver.findElement(By.partialLinkText("Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)")).click();
System.out.println("done");
//submitting the payment option
driver.findElement(By.xpath("//input[@value='submit']")).click();
//Logging out from the application
driver.findElement(By.xpath("//a[@href='logout.php']")).click();
String ADMIN_U_NAME=fLib.readDataFromPropertiesFile("admUsername");
String ADMIN_PASSWORD=fLib.readDataFromPropertiesFile("admPassword");
String ADMIN_URL=fLib.readDataFromPropertiesFile("admUrl");
driver.get(ADMIN_URL);
driver.findElement(By.name("username")).sendKeys(ADMIN_U_NAME);
driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
driver.findElement(By.xpath("//button[text()='Login']")).click();	
driver.findElement(By.xpath("//a[@class='collapsed']")).click();
driver.findElement(By.xpath("//a[@href='href=todays-orders.php']")).click();
driver.findElement(By.xpath("//select[@aria-controls='DataTables_Table_0']")).sendKeys(ProdName);

	}

}




