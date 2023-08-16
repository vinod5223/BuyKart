package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_RankingsTask {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/overview");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/**
		 * @author we can use this without index
		 */
		//h4[.='ODI Team Rankings']/../parent::div/following-sibling::table//tbody/tr[*]/td[contains(.,'England')]
		
		
		String ele= driver.findElement(By.xpath("//h4[.='ODI Team Rankings']/../parent::div/following-sibling::table//tbody/tr[last()]/td[2]")).getText();
		System.out.println(ele);
	}

}
