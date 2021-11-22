package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {

	WebDriver driver=null;

	@Test
	public void test1() {
		System.out.println("I ama inside Test 1");
	}

	@Test
	public void test2() {
		System.out.println("I ama inside Test 2");
		//Assert.assertTrue(false);
	}

	@Test
	public void testSelenium() {
		System.out.println("I ama inside Test Selenium");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://google.com");
		
		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}

		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("abcd");
		//driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abc");
		driver.close();
		//driver.quit();
	}


	@Test
	public void test3() {
		System.out.println("I ama inside Test 3");
		//throw new SkipException("This test is skipped");
	}


}
