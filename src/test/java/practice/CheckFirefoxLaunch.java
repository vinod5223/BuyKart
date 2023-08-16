package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.BuyKart.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckFirefoxLaunch {

	public static void main(String[] args) {
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver= new FirefoxDriver();



		JavaUtility jutil= new JavaUtility();
		String date=jutil.getSystemDateInFormat("YYYY-MM-dd hh:mm:ss");
		System.out.println(date);
		System.out.println(date);
	
	}

}
