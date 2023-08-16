package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMytripCalendarTest {

	public static void main(String[] args) {
		
		String monthAndYear="August 2023";
		int actualDate= 29;
		
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.makemytrip.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions act= new Actions(driver);
	act.moveByOffset(40, 40).click().perform();
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	
	String pathForDate="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+actualDate+"']";
	for(;;)
		try {
			driver.findElement(By.xpath(pathForDate)).click();
			break;
		}
	catch (Exception e) {
		driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
	}	
	}

}
