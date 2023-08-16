package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Starting10_Countries {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String first=driver.findElement(By.xpath("//td[@class='rankings-block__banner--pos' and text()<=10]/following-sibling::td//span[@class='u-hide-phablet']")).getText();
		System.out.println(first);
		List<WebElement> names =driver.findElements(By.xpath("//td[@class='table-body__cell table-body__cell--position u-text-right' and text()<=10]/following-sibling::td//span[@class='u-hide-phablet']"));
		
		Iterator<WebElement> itr= names.iterator();
		while(itr.hasNext()) {
			String country=itr.next().getText();
			System.out.println(country);
		}
	}

}
