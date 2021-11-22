package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import config.PropertiesFile;


public class TestING_Demo {
	WebDriver driver=null;
	public static String browserName=null;
	/*public static void main(String[] args) throws InterruptedException {
		googleSearch();
	}
	 */

	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}

	}

	@Test
	public  void googleSearch() throws InterruptedException {

		driver.get("https://google.com");

		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		Thread.sleep(2000); //arrêt de deux sécondes pour voir ce qui se passe
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN); //permet d'apputer sur la touche "Entrée"
		Thread.sleep(2000);

	}

	@AfterTest
	public void tearDownTest() {

		driver.close();
		//driver.quit();
		System.out.println("Test completed succesfully");
		PropertiesFile.setProperties();

	}
}
