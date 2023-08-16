package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenTwitterTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://twitter.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
		ArrayList<String> brokenLinks= new ArrayList<String>();
		
		URL url=null;
		for(int i=0; i<allLinks.size();i++) {
			String eachlink = allLinks.get(i).getAttribute("href");
			try {
				url= new URL(eachlink);
				HttpURLConnection connections= (HttpURLConnection) url.openConnection();
				
				
				
			}
			
			
			
			
			
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				
			}
			
			
			
			
			
			
		}
		
	}

}












