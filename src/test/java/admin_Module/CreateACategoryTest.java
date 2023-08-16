package admin_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.BuyKart.GenericUtility.ExcelUtility;
import com.BuyKart.GenericUtility.FileUtility;
import com.BuyKart.GenericUtility.JavaUtility;
import com.BuyKart.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateACategoryTest {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility jLib= new JavaUtility();
		ExcelUtility eLib= new ExcelUtility();
		FileUtility fLib= new FileUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
//		Random rn=new Random();
//		int random = rn.nextInt(100);
		
		int random= jLib.getRandomNo();
		
		//fetching the data from properties file
		String BROWSER=fLib.readDataFromPropertiesFile("browser");
		String ADMIN_URL=fLib.readDataFromPropertiesFile("admUrl");
		String ADMIN_U_NAME=fLib.readDataFromPropertiesFile("admUsername");
		String ADMIN_PASSWORD=fLib.readDataFromPropertiesFile("admPassword");
		
//		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonDataForOSA.properties");
//		Properties pObj= new Properties();
//		pObj.load(fis);
//		
//		String BROWSER=pObj.getProperty("browser");
//		String ADMIN_URL=pObj.getProperty("admUrl");
//		String ADMIN_U_NAME=pObj.getProperty("admUsername");
//		String ADMIN_PASSWORD=pObj.getProperty("admPassword");

		String categoryName =eLib.getDataFromExcel("Categories", 1, 0)+random;
		String description =eLib.getDataFromExcel("Categories", 1, 1);	
//		FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		 String categoryName = wb.getSheet("Categories").getRow(1).getCell(0).getStringCellValue()+random;
//		 String description = wb.getSheet("Categories").getRow(1).getCell(1).getStringCellValue();
		 System.out.println(categoryName);
		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		//login to the application		
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ADMIN_URL);
		wLib.waitForPageLoad(driver, 10);
		
		wLib.maximizeWindow(driver);
		
//		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys(ADMIN_U_NAME);
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.xpath("//button[text()='Login']")).click();	
		//creating a category
		driver.findElement(By.xpath("//a[@href='category.php']")).click();
		driver.findElement(By.name("category")).sendKeys(categoryName);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
		driver.findElement(By.xpath("//button[text()='Create']")).click();	
		String successMsg = driver.findElement(By.xpath("//div[@class='module-body']/descendant::strong")).getText();
		System.out.println(successMsg);	
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(categoryName);	
		//verifying the created category
		String storedValue=driver.findElement(By.xpath("//tbody[@aria-live='polite']/descendant::td[text()='"+categoryName+"']")).getText();
		if(storedValue.equals(categoryName)) {
			System.out.println("Category created successfully");
		}
		else
			System.out.println("Category not created");
		driver.close();
	}

}
