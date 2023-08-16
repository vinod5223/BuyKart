package user_Module;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;
import com.BuyKart.ObjectRepository.LoginAndSignUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpToApplicationTest {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jLib= new JavaUtility();
		
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		FileUtility fLib= new FileUtility();
//		fetching the data from properties file
		String BROWSER = fLib.readDataFromPropertiesFile("browser");
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
		
		HashMap<String, String> map = eLib.getMultipleDataFromExcel(driver, "CreateUserAccount", 0, 1);
		int ran=jLib.getRandomNo();
		LoginAndSignUpPage lsp= new LoginAndSignUpPage(driver);
		lsp.signUp(map, driver, jLib, ran, wLib);
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String expEmKey="emailid";
//		String expPass="password";
//		String em=null;
//		String pass=null;
//		
//		for(Entry<String, String> set:map.entrySet()) {
//			if(set.getKey().equalsIgnoreCase(expEmKey)) {
//			em= rand+set.getValue();
//			driver.findElement(By.name(set.getKey())).sendKeys(em);
//			}
//			else if(set.getKey().equalsIgnoreCase(expPass)) {
//				pass= set.getValue();
//				driver.findElement(By.id(set.getKey())).sendKeys(pass);
//				}
//			else {
//				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//				 }	
//		}
//		driver.findElement(By.xpath("//button[text()='Sign Up']")).click(); 
//		String registered=wLib.alertPopGetText(driver);
//		wLib.acceptAlertPopUp(driver);
//		//logging in as a created user
//		if(registered.equalsIgnoreCase("You are successfully register"))
//		{
//			System.out.println("account created successfully");
//			driver.findElement(By.name("email")).sendKeys(em);
//			driver.findElement(By.name("password")).sendKeys(pass, Keys.ENTER);		
//		}	
	
		
		
		
		
		
		
		
		
		
//		
//		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		String FULL_NAME = wb.getSheet("CreateUserAccount").getRow(1).getCell(0).getStringCellValue();
//		String emailID=wb.getSheet("CreateUserAccount").getRow(1).getCell(1).getStringCellValue();
//		String emailExtension= wb.getSheet("CreateUserAccount").getRow(1).getCell(2).getStringCellValue();
//		String fullEmail= emailID+rand+emailExtension;
//
//		DataFormatter df= new DataFormatter();
//		  Cell cl=wb.getSheet("CreateUserAccount").getRow(1).getCell(3);
//		  
//		  String contactno=df.formatCellValue(cl);
//		  
//		String PASSWORD= wb.getSheet("CreateUserAccount").getRow(1).getCell(4).getStringCellValue();
//		String CONF_PASSWORD= wb.getSheet("CreateUserAccount").getRow(1).getCell(5).getStringCellValue();
//		driver.findElement(By.name("fullname")).sendKeys(FULL_NAME);
//		driver.findElement(By.name("emailid")).sendKeys(fullEmail);
//		driver.findElement(By.id("contactno")).sendKeys(contactno);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("confirmpassword")).sendKeys(CONF_PASSWORD);
//		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
//		
//
//		Alert alt= driver.switchTo().alert();
//		String registered=alt.getText();
//		alt.accept();
//		
//		//checking the confirmation pop-up
//		if(registered.equalsIgnoreCase("You are successfully register"))
//		{
//			System.out.println("account created successfully");
//			
//		}
	
		
