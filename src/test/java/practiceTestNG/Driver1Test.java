package practiceTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver1Test {

	public static void main(String[] args) {
			WebDriver driver= new ChromeDriver();
			driver.navigate().to("https://www.google.com/");
	}

}
