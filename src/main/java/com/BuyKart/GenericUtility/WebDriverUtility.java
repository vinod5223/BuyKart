package com.BuyKart.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	
	WebDriver driver;
	 /**
	  * This method is used to maximize the window
	  * @param driver
	  */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	
	
	public void waitForPageLoad(WebDriver driver, int timeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
	}
	
	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void  select(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(WebElement element, String value) {
		Select sel= new Select(element);
		sel.selectByValue(value);

	}
	public void select(String text, WebElement element) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void mouseHoverClickAction(WebDriver driver , WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	public void doubleClickOnElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions act= new Actions(driver);
		act.dragAndDrop(src, dest);
		
	}
	public void enterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterKeyPress(WebDriver driver) throws AWTException {
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterKeyRelease(WebDriver driver) throws AWTException {
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, String stringOrID) {
		driver.switchTo().frame(stringOrID);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	} 
	
	public void switchToFrame(WebDriver driver, WebElement elementInFrame) {
		driver.switchTo().frame(elementInFrame);
	}
	
	public void acceptAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public String alertPopGetText(WebDriver driver) {
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	public void alertPopSendKeys(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
	public void switchToWindow(WebDriver driver, String partialTitle) {
		Set<String> windowIDs = driver.getWindowHandles();
 	Iterator<String> itr= windowIDs.iterator();
 	while(itr.hasNext()) {
	 String windowID= itr.next();
	 
	 String 	currentWindowTitle= driver.switchTo().window(windowID).getTitle();

	if(currentWindowTitle.contains(partialTitle)) {
		break;
			}
 		}
 	}
	
	public String getScreenshot(WebDriver driver, String screenShotName ) throws Throwable {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path= ".\\screenshot\\"+screenShotName+".png";
		File dst= new File(path);
//		Files.copy(src, dst);
		FileUtils.copyFile(src, dst);
		path="../screenshot/"+screenShotName+".png";
		return path;
	}
		
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800);", "");
	}	
}
































