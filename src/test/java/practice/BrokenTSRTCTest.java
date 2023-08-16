package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenTSRTCTest {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tsrtconline.in/oprs-web/");
		List<WebElement> all_Links= driver.findElements(By.xpath("//a"));
		System.out.println(all_Links.size());
		ArrayList<String> linksList= new ArrayList<String>();
		
		for(int i=0;i<all_Links.size();i++) {
			String eachlink= all_Links.get(i).getAttribute("href");
			URL link= new URL(eachlink);
			HttpURLConnection connection= (HttpURLConnection) link.openConnection();
			int statusCode=connection.getResponseCode();
			if(statusCode<=400) {
				
				linksList.add(eachlink);
				
			}
		}
	System.out.println(linksList);
	System.out.println(linksList.size());
	
	}

}








































