package practice2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksPrac {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://transport.telangana.gov.in/");
		List<WebElement> allURLs= driver.findElements(By.xpath("//a"));
		System.out.println(allURLs.size());
		
		ArrayList<String> brokenLinks= new ArrayList<String>();
		
		URL eachlink=null;
		
		for(int i=0; i<allURLs.size();i++) {
			String link=allURLs.get(i).getAttribute("href");
			
			try {
				eachlink= new URL(link);
			
			HttpURLConnection newLink= (HttpURLConnection) eachlink.openConnection();
			int statusCode=newLink.getResponseCode();
			if(statusCode>=400) {
				brokenLinks.add(link);
			}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(brokenLinks);
		
		
		System.out.println("done");
		
	}

}
