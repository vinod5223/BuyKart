package practice;

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

public class BrokenLinkIRCTCTest{

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.irctc.co.in/nget/train-searchj");
		List<WebElement> allLinks= driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		ArrayList<String> links= new ArrayList<String>();
		URL urlLink= null;
		
		int statuscode=0;
		for(int i=0; i<allLinks.size();i++) {
			String eachlink = allLinks.get(i).getAttribute("href");
			try {
				urlLink= new URL(eachlink);
				HttpURLConnection connection= (HttpURLConnection) urlLink.openConnection();
				statuscode=connection.getResponseCode();
				if(statuscode>=400) {
					links.add(eachlink+"---:>"+statuscode);
				}	
			}
			
			catch(Exception e) {
//				links.add(eachlink+"--->"+statuscode);
			}
		}
		System.out.println(links);
		System.out.println(links.size());
	driver.close();	
	}

}
