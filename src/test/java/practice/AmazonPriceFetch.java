package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceFetch {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("iphone", Keys.ENTER);	
	try {
		WebElement ele= driver.findElement(By.xpath("//span[text()='Apple iPhone 14 (128 GB) - Blue']/ancestor::h2/preceding-sibling::div/parent::div/following-sibling::div[@class='sg-row']/descendant::span[@class='a-price']"));
		System.out.println(ele.getText()+"1");
	}
	 catch (Exception e) {
		WebElement ele= driver.findElement(By.xpath("//span[contains(text(),'14 (128 GB) - Blue')]/ancestor::h2/preceding-sibling::div/parent::div/following-sibling::div[@class='sg-row']//span[@class='a-price']"));
		System.out.println(ele.getText()+"2");
	}
driver.close();
}
}



