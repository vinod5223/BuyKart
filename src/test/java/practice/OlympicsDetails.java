package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsDetails {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	
		String country_name= "Bahrain";
//		driver.findElement(By.xpath("//span[.='Argentina']"));
//		
//		driver.findElement(By.xpath("//span[.='Argentina']/../following-sibling::div[@data-medal-id='gold-medals-row-1']"));
//		
//		driver.findElement(By.xpath("//span[@data-cy='"+country_name+"']/../following-sibling::div[@data-medal-id='gold-medals-row-1']"));
		
		List<WebElement> ranks= driver.findElements(By.xpath("//div[text()='"+country_name+"']/preceding-sibling::div/span/span"));
		
		System.out.print(country_name+" --->   ");
		for(int i=ranks.size()-4;i<ranks.size();i++) {
			String abbo=ranks.get(i).getText();
			System.out.print(abbo+"  ");
		}
		
		Thread.sleep(6000);
//	driver.close();
	
	
	
	}

}
 