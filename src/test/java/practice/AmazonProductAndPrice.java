package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProductAndPrice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("iphone", Keys.ENTER);
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> prices= driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		Iterator<WebElement> itr1= products.iterator();
		Iterator<WebElement> itr= prices.iterator();
		for(int i=0; i<products.size(); i++) {
			String price=itr.next().getText();
			String product= itr1.next().getText();
			System.out.println(product+"---->"+price);
		}
		
		
	}

}
