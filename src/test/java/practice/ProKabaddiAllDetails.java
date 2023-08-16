package practice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProKabaddiAllDetails {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");

		/**
		 * @author this is another xpath to find the matches played
		 */
		//p[@class='name' and text()='Jaipur Pink Panthers']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']/p
		
		
		String teamName="Jaipur Pink Panthers";
	String rank= driver.findElement(By.xpath("//p[@class='name' and text()='"+teamName+"']/../../../following-sibling::div[@class='table-data matches-play']//p")).getText();
//		System.out.println(rank);
		List<WebElement> winLost= driver.findElements(By.xpath("(//ul[@class='form-listing'])[1]/li"));
		String s="";
		Iterator<WebElement> itr= winLost.iterator();
		while(itr.hasNext()) {
String p=	itr.next().getText();
s=s+" "+p+" ";
//System.out.print(s);
		}
		
List<WebElement>	ff=	driver.findElements(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div"));
Iterator<WebElement> itrtr= ff.iterator();
String pp1="";
for(int i=1; i<=5;i++) {
	
pp1=pp1+" "+	itrtr.next().getText();


}		
Thread.sleep(3000);
		
String l=driver.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data points']//p")).getText();
		

System.out.print(teamName+" "+pp1+" "+s+" "+l);		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.close();
		
		
		
	}

}
