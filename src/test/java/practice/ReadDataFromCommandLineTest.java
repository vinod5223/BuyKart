package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromCommandLineTest {
@Test
	public void readDataFromCmdLine() {
		
//		String BROWSER=System.getProperty("browser");
		String URL= System.getProperty("url");
		String USERNAME= System.getProperty("username");
		String PASSWORD = System.getProperty("password");
//		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys(PASSWORD);
		
	}
}
