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

public class BrokenLinksUIDAITest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://uidai.gov.in/");
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
		System.out.println(listOfLinks.size());
		ArrayList<String> Links= new ArrayList<String>();
		URL url= null;
		int statuscodes=0;
		for(int i=0; i<listOfLinks.size(); i++) {
			String eachLink = listOfLinks.get(i).getAttribute("href");
			try {
			 url = new URL(eachLink);
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				statuscodes = connection.getResponseCode();
				
				if(statuscodes<=400) {
					Links.add(eachLink+" "+statuscodes);
				}
			}
			catch(Exception e) {
				Links.add(eachLink+" "+statuscodes);
			}
		}
		System.out.println(Links);
		driver.close();
	}
}
