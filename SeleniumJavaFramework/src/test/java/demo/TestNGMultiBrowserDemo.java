package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {

	WebDriver driver=null;

	//@Parameters("browserName") est configuré dans le dichier xml testngMutiBrowser.xml
	// <suite name="Suite1" parallel="tests" thread-count="3">
	//permet de lancer les test en parrallèles sur plusieurs navigateurs
 
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {

		System.out.println("Browser name is :"+browserName);
		System.out.println("Thread id :"+Thread.currentThread().getId());


		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver= new EdgeDriver();
		}


	}

	@Test
	public void test1() throws Exception{
		driver.get("https://google.com");
		Thread.sleep(4000);

		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}

	}

	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("Test completed successfully");
	}

}
