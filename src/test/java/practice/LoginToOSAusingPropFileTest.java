package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToOSAusingPropFileTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataForOSA.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String URL=prop.getProperty("custUrl");
		String BROWSER= prop.getProperty("browser");
		String CUST_USERNAME=prop.getProperty("custUsername");
		String CUST_PASSWORD=prop.getProperty("custPassword");
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver= new FirefoxDriver();
		
		
			if(BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox")){
				WebDriverManager.firefoxdriver().setup();
				
				driver = new FirefoxDriver();
			}
			else{
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foption= new FirefoxOptions();
				foption.setCapability("marionette", true);
				driver = new FirefoxDriver(foption);
			}
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.name("email")).sendKeys(CUST_USERNAME, Keys.TAB, CUST_PASSWORD, Keys.ENTER);
			driver.findElement(By.xpath("//a[@href='logout.php']")).click();
			driver.close();
			System.out.println("browser closed");
			fis.close();
			System.out.println("prop file closed");
			
			
			
			
		
	}

}
