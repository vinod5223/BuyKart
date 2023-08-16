package com.BuyKart.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{

	
	
	
	ExtentTest	test;
	ExtentReports report;
	public void onTestStart(ITestResult result) {
		
	String methodName=result.getMethod().getMethodName();
		
		
	test=report.createTest(methodName);
	Reporter.log(methodName+"Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"passed");
		Reporter.log(methodName+"passed");
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriverUtility wLib= new WebDriverUtility();
		JavaUtility jLib= new JavaUtility();
		String methodName=result.getMethod().getMethodName()+jLib.getSystemDateInFormat("dd-mm-yyyy HH-MM-SS");
		
		try {
			String failedScriptCapture = wLib.getScreenshot(BaseClass.driver, methodName);
			test.addScreenCaptureFromPath(failedScriptCapture);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(methodName+"failed");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"Skipped");
		
	}

	public void onStart(ITestContext context) {

			ExtentSparkReporter htmlReport= new ExtentSparkReporter("./ExtentReports/report.html");
			htmlReport.config().setDocumentTitle("TestYantraSoft");
			htmlReport.config().setTheme(Theme.STANDARD);
			htmlReport.config().setReportName("BuyKart");
			
			report= new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("browser", "Chrome");
			report.setSystemInfo("URL", "http://rmgtestingserver/domain/Online_Shopping_Application/login.php");
			report.setSystemInfo("reporterName", "Vinod");		
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	
}
