package practice2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver();
		WebDriver driver= new ChromeDriver();
		driver.get("protocol://username:password@URL_address");
		driver.get("https://selenium:webdriver@chercher.tech/auth/");
		driver.navigate().to("https://www.google.com/");
		driver.navigate().refresh();
		
		
		
	}

}
