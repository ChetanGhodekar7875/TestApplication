package BasePackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseClass {
	
	protected static  WebDriver webDriver;
	protected ExtentReports extent;
	protected  ExtentTest test;
	@BeforeClass
	public void launchApplication() {
		System.out.println("hi");
		webDriver=new EdgeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		webDriver.manage().window().maximize();
		webDriver.get("https://www.shoppersstack.com");
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./test-output/ExtentReport.html");
	      	
		 	extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        test = extent.createTest(getClass().getSimpleName());
	}
	
	
	@AfterClass
	public void closeApplication() {
		webDriver.close();
	}
}
