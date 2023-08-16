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

public class AmazonBrandAndProducts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("mobiles", Keys.ENTER);	
		
		List<WebElement> checks=driver.findElements(By.xpath("//span[contains(@data-csa-c-content-id,'p_89')]"));
		String brand="";
		Iterator<WebElement> itr= checks.iterator();
		while(itr.hasNext()) {
			String SAMSUNG=itr.next().getText();
			if(SAMSUNG.equalsIgnoreCase("samsung")) {
				driver.findElement(By.xpath("//span[text()='Samsung']")).click();
				brand=SAMSUNG;
				break;			
			}
		}
		System.out.println(brand);
		List<WebElement> pNames=driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
		
		Iterator<WebElement> itr1= pNames.iterator();
		for(int i=1;i<=pNames.size();i++) {
			String allPnames=itr1.next().getText();
			if(allPnames.contains(brand)) {
				System.out.println(i+"th item matched");
			}
			else {
				System.out.println(i+"th item not matched");
			}
		}
		driver.close();
	
	}

}
