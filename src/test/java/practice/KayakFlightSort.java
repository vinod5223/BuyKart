package practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakFlightSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.kayak.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement from=	driver.findElement(By.xpath("//input[@aria-label='Flight origin input']"));
from.click();
driver.findElement(By.xpath("//div[@aria-label='Remove']")).click();
from.sendKeys("Hyderabad");
Thread.sleep(1000);
driver.findElement(By.xpath("//span[text()='HYD']")).click();
WebElement to= driver.findElement(By.xpath("//input[@placeholder='To?']"));
to.click();
to.sendKeys("Delhi");
Thread.sleep(1000);
driver.findElement(By.xpath("//span[text()='Indira Gandhi Intl']")).click();
		
driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();

WebElement startDate= driver.findElement(By.xpath("//div[@aria-label='Tuesday 1 August, 2023']"));
startDate.click();
WebElement endDate= driver.findElement(By.xpath("//div[@aria-label='Friday 4 August, 2023']"));
endDate.click();
try{
	endDate.submit();
}
catch (Exception e) {
	driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
}

String parentID= driver.getWindowHandle();
Set<String> childIDs= driver.getWindowHandles();

Iterator<String> itr= childIDs.iterator();

while(itr.hasNext()) {
String current=	itr.next();
String now=driver.switchTo().window(current).getTitle();
if(now.equals(parentID)) {
	break;
}
}
driver.findElement(By.xpath("//div[@aria-label='Other sort']")).click();
driver.findElement(By.xpath("//li[@aria-label='Slowest']")).click();













		
		
		
	}

}





































//List<WebElement> months = driver.findElements(By.xpath("//div[@class='wHSr-monthName']"));
//
//String myMonthAndYear= "July 2023";
//		
//Iterator<WebElement> itM= months.iterator();
//
//for(int i=0;i<months.size();i++) {
//String month=	itM.next().getText();
//if(month.equalsIgnoreCase(myMonthAndYear)) {
//	driver.findElement(By.xpath("//div[@aria-label='Thursday 27 July, 2023']")).click();
//	break;
//}
//else {
//	driver.findElement(By.xpath("//button[@aria-label='Previous month']")).click();
//}
//}
		
		
		
		
		
