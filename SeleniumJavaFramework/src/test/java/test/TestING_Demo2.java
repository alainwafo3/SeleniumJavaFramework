package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class TestING_Demo2 {
	WebDriver driver=null;
	/*public static void main(String[] args) throws InterruptedException {
		googleSearch();
	}
	 */

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver= new ChromeDriver();
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
		driver.quit();

	}
}
