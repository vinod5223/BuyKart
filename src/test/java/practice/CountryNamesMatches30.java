package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryNamesMatches30 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String f=driver.findElement(By.xpath("//td[@class='rankings-block__banner--matches' and text()>30]/preceding-sibling::td[@class='rankings-block__banner--team-name']")).getText();
		String ma=driver.findElement(By.xpath("//td[@class='rankings-block__banner--matches' and text()>30]")).getText();
		
		
		System.out.println(f+" "+ma);
		List<WebElement> teams =driver.findElements(By.xpath("//tr[@class='table-body']//td[3][@class='table-body__cell u-center-text' and text()>30]/preceding-sibling::td[@class='table-body__cell rankings-table__team']"));
		List<WebElement> matches= driver.findElements(By.xpath("//tr[@class='table-body']//td[3][@class='table-body__cell u-center-text' and text()>30]"));
		Iterator<WebElement> itrM= matches.iterator();
		Iterator<WebElement> itr= teams.iterator();
		while(itr.hasNext()) {
			String all=itr.next().getText();
			String m=itrM.next().getText();
			System.out.println(all+" "+m);
		}
		
//		System.out.println(teams.size()+1);
		driver.close();
	}

}
