package practice2;



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

public class BrokenLinkTSRTA_Test {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://transport.telangana.gov.in/");
List<WebElement>	allLinks = 	driver.findElements(By.xpath("//a"));
System.out.println(allLinks.size());
ArrayList<String> brokenLinks= new ArrayList<String>();
ArrayList<String> workingLinks= new ArrayList<String>();

URL eachLink;


		for(int i=0;i<allLinks.size();i++) {
			String link=allLinks.get(i).getAttribute("href");
			try {
				eachLink= new URL(link);	
			
			
			HttpURLConnection connection= (HttpURLConnection) eachLink.openConnection();
			
			int statusCode=connection.getResponseCode();
			if(statusCode>=400) {
				brokenLinks.add(link+""+statusCode);
			}
			else
			{
				workingLinks.add(link+""+statusCode);
			}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			}
			
System.out.println(brokenLinks.size());
System.out.println(brokenLinks);
System.out.println(workingLinks.size());
System.out.println(workingLinks);

Thread.sleep(3000);
driver.close();

	}

}






