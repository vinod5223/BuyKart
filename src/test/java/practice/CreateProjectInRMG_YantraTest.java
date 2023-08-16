package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectInRMG_YantraTest {

	public static void main(String[] args) throws SQLException {
		
		
	Random r= new Random();
	int rand=r.nextInt(100);
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver:8084/");
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra",Keys.TAB, "rmgy@9999", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		String projectname="BuyKart01";
		driver.findElement(By.name("projectName")).sendKeys(projectname+""+rand,Keys.TAB, "Vinod");
		WebElement dd = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sele= new Select(dd);
		sele.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		String expected=projectname+""+rand;
		
		Driver jdbcDriver= new Driver();
		DriverManager.registerDriver(jdbcDriver);
		Connection conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement st=conn.createStatement();
		String query="select * from project;";
		ResultSet result = st.executeQuery(query);
		boolean flag=false;
		while (result.next()) {
			String actual=result.getString(4);
			if(actual.equalsIgnoreCase(expected)) {
				
				flag=true;
				break;
			}
	}
		if(flag) {
			System.out.println("data created succesfully");
		}
		else
			System.out.println("project not created");

		//http://rmgtestingserver:3333/
		//http://rmgtestingserver:3333/
		//3333/projects, root@%, root
		//table name is project
		
	}

}
