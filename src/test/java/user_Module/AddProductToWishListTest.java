package user_Module;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductToWishListTest {

	public static void main(String[] args) throws Exception {
		//fetching the data from properties file
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
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
		String product="Apple iPhone 6 (Silver, 16 GB)";
		driver.findElement(By.name("email")).sendKeys(CUST_U_NAME);
		driver.findElement(By.name("password")).sendKeys(CUST_PASSWORD, Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("//div[text()=' Categories']/ancestor::div/descendant::a[@href='category.php?cid=4']")).click();
		driver.findElement(By.xpath("//a[@href='sub-category.php?scid=4']")).click();
		driver.findElement(By.xpath("//a[text()='"+product+"']/../../following-sibling::div/descendant::i[@class='icon fa fa-heart']")).click();
		List<WebElement> WishListProducts=driver.findElements(By.xpath("//div[@class='product-name']"));
		for(int i=WishListProducts.size()-1; i<WishListProducts.size();i++) {
			String presentProduct=WishListProducts.get(i).getText();
			if(product.equalsIgnoreCase(presentProduct)) {
				System.out.println("Product added");
				break;
			}
		}
	System.out.println("success");
	}

}
