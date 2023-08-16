package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSamsungProductsPrices {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
try {
	driver.findElement(By.xpath("//button[text()='✕']")).click();
}catch (Exception e) {
	// TODO: handle exception
}
WebElement search= driver.findElement(By.xpath("//input[@name='q']"));
search.sendKeys("samsung");
search.submit();
List<WebElement> names= driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3']"));

Iterator<WebElement> itNames= names.iterator();
Iterator<WebElement> itPrices=prices.iterator();

while(itNames.hasNext()) {
String finalNames=	itNames.next().getText();
String finalPrices=  itPrices.next().getText();
System.out.println(finalNames+"------:>"+finalPrices);
}
driver.close();
	}

}















