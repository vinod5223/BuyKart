package user_Module;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateUserAccountTest {
	public static void main(String[] args) throws Throwable {
		JavaUtility jLib= new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
		int rand=jLib.getRandomNo();			
		String BROWSER=fLib.readDataFromPropertiesFile("browser");
		String CUST_URL=fLib.readDataFromPropertiesFile("custUrl");	
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver= new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		driver.get(CUST_URL);
		 String FULL_NAME = eLib.getDataFromExcel("CreateUserAccount", 0, 1);
		 String  fullEmail= FULL_NAME+rand+ eLib.getDataFromExcel("CreateUserAccount", 1, 1);		 
		 String contactno=eLib.getDataFromExcel("CreateUserAccount", 2, 1);
		 String PASSWORD=eLib.getDataFromExcel("CreateUserAccount", 4, 1);
		 String CONF_PASSWORD= eLib.getDataFromExcel("CreateUserAccount", 3, 1);
		driver.findElement(By.name("fullname")).sendKeys(FULL_NAME);
		driver.findElement(By.name("emailid")).sendKeys(fullEmail);
		driver.findElement(By.name("contactno")).sendKeys(contactno);
		driver.findElement(By.name("confirmpassword")).sendKeys(CONF_PASSWORD);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click(); 
		String registered=wLib.alertPopGetText(driver);
		wLib.acceptAlertPopUp(driver);
		//logging in as a created user
		if(registered.equalsIgnoreCase("You are successfully register"))
		{
			System.out.println("account created successfully");
			driver.findElement(By.name("email")).sendKeys(fullEmail);
			driver.findElement(By.name("password")).sendKeys(PASSWORD, Keys.ENTER);		
		}
		String ADMIN_U_NAME=fLib.readDataFromPropertiesFile("admUsername");
		String ADMIN_PASSWORD=fLib.readDataFromPropertiesFile("admPassword");
		String ADMIN_URL=fLib.readDataFromPropertiesFile("admUrl");
		driver.get(ADMIN_URL);
		driver.findElement(By.name("username")).sendKeys(ADMIN_U_NAME);
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.xpath("//button[text()='Login']")).click();		
		driver.findElement(By.xpath("//a[@href='manage-users.php']")).click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(fullEmail);
		String createdUser= driver.findElement(By.xpath("//th[text()='Email ']/ancestor::table/descendant::td[text()='"+fullEmail+"']")).getText();
		if(createdUser.equals(fullEmail)) {
			System.out.println("User creation verified cuccessfully");
		}		
	}
}


