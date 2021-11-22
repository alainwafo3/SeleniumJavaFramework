package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {
	private static WebDriver driver=null;

	public static void main(String[] args) throws InterruptedException {

		// See this page https://www.extentreports.com/docs/versions/5/java/index.html
		//ExtentHtmlReporter is depreciated in version4 so we will use spark. ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html"); 
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html"); 

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		
		ExtentTest test1= extent.createTest("Google Search Test One", "This is a test to validate google search functionality");

		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver= new ChromeDriver();
		
		test1.log(Status.INFO,"Starting Test Case");

		
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");

		
		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		test1.pass("Entered test in Searchbox");
		Thread.sleep(2000); //arrêt de deux sécondes pour voir ce qui se passe
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test1.pass("Pressed keyboard enter key");

		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN); //permet d'apputer sur la touche "Entrée"
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test completed");
		
	
		//calling flush writes everything to the log file
		extent.flush();
		


		//extent.flush();

		//ExtentTest = test1=  extent.createTest("MyFirstTest","");

	}

}
