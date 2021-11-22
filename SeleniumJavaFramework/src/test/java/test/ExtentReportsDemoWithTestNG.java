package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gson.GsonExtentTypeAdapterBuilder.Builder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {
	ExtentSparkReporter htmlReporter ;
	ExtentReports extent;
	WebDriver driver=null;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentSparkReporter("extentReportsTestNG.html"); 
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);



	}


	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver= new ChromeDriver();

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test completed succesfully");
	}

 
	@Test
	public void test1() {
		ExtentTest test= extent.createTest("My first Test", "Sample description");
		test.log(Status.INFO, "This steps shows usage of log(status,details)");
		test.info("This steps shows usage of info(details)");
		test.fail("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}

	@Test
	public void test2() {
		ExtentTest test= extent.createTest("My second Test", "Sample description");
		test.log(Status.INFO, "This steps shows usage of log(status,details)");
		test.info("This steps shows usage of info(details)");
		test.pass("details",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}


	@AfterSuite
	public void tearDown() {
		extent.flush();

	}

}
