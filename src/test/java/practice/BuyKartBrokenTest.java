package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyKartBrokenTest {

	public static void main(String[] args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
	List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
	ArrayList<String> links= new ArrayList<String>();
	System.out.println(allLinks.size());
	
	URL url=null;
	int statusCode=0;
	for(int i=0; i<allLinks.size(); i++) {
		String eachLink=allLinks.get(i).getAttribute("href");
		try {
			url= new URL(eachLink);
			HttpURLConnection connection= (HttpURLConnection) url.openConnection();
			statusCode= connection.getResponseCode();
			
			if(statusCode>=400) {
			links.add(eachLink+"--"+statusCode);
			}	
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			
		}
		
	}
	System.out.println(links);
	System.out.println(links.size());
	
	}

}
