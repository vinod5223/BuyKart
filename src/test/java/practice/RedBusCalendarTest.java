package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusCalendarTest {

	public static void main(String[] args) throws InterruptedException {

		int year = 2023;
		String month ="Aug";
		int date= 30;
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//text[text()='Hyderabad']")).click();
		
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//text[text()='Bangalore']")).click();
		
		driver.findElement(By.xpath("//div[@class='labelCalendarContainer']")).click();
		for(;;) {	
			try {
				driver.findElement(By.xpath("//div[text()='"+month+"' and '"+year+"']/ancestor::div/descendant::span[text()='"+date+"']")).click();
				break;
			}
			catch (Exception e) {
				driver.findElement(By.id("Layer_1")).click();
			}
				
		}
		driver.findElement(By.xpath("//button[@class='sc-dxgOiQ eQQkuo']")).click();
		System.out.println("done");
		
		 
	}

}



























//Thread.sleep(3000);
//System.out.println("hjvjhv");
//driver.findElement(By.xpath("//button[@id=\"search_button\"]")).click();
//System.out.println("excec");
