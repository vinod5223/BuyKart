package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_FetchAllData {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String heading=driver.findElement(By.xpath("//tr[@class='table-head']")).getText();
		System.out.println(heading);

		String pos1=driver.findElement(By.xpath("//table//tbody/tr[*]/td[@class='rankings-block__banner--pos']")).getText();
		String teamName= driver.findElement(By.xpath("//table//tbody/tr[*]/td[@class='rankings-block__banner--team-name']")).getText();
		String matches = driver.findElement(By.xpath("//table//tbody/tr[*]/td[@class='rankings-block__banner--matches']")).getText();
		String points= driver.findElement(By.xpath("//table//tbody/tr[*]/td[@class='rankings-block__banner--points']")).getText();
		String rating= driver.findElement(By.xpath("//table//tbody/tr[*]/td[@class='rankings-block__banner--rating u-text-right']")).getText();
		
		System.out.print(pos1+" "+teamName+" "+matches+" "+points+" "+rating);
		System.out.println();
		
//		String first= driver.findElement(By.xpath("//table//tbody/tr[@class='rankings-block__banner']")).getText();
//		System.out.print(first);
//		
		
		List<WebElement> all= driver.findElements(By.xpath("//table//tbody/tr[@class='table-body']"));
		Iterator<WebElement> itr= all.iterator();
		
		while(itr.hasNext()) {
			String eachData=itr.next().getText();
			System.out.println(eachData);
		}
		
		
		
		
		
		
//		
//		
//		
//		List<WebElement> allDataF2 =driver.findElements(By.xpath("//table//tbody/tr[*]/td[@class='table-body__cell table-body__cell--position u-text-right']"));
//		
//		
		
		
		
		
		driver.close();
		
		
	}

}
