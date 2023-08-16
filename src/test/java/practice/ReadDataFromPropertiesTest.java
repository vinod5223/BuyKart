package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromPropertiesTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataForAdmin.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		
		String URL=pObj.getProperty("url");
		String BROWSER=pObj.getProperty("browser");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME, Keys.TAB, PASSWORD, Keys.ENTER);
		Thread.sleep(4000);
		driver.close();
		fis.close();
		
		
		
	}

}
