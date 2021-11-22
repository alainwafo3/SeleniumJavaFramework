package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


//https://www.youtube.com/watch?v=iUQIL2VsHIk&list=PLhW3qG5bs-L8oRay6qeS70vJYZ3SBQnFa&index=32
//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");


		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}

		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id=\"rso\"]/div[4]/div/div/div[1]/a/h3")).click();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout( Duration.ofSeconds(30))
				.pollingEvery( Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				WebElement linkElement =		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[4]/div/div/div[1]/a/h3"));
				;
				if(linkElement.isEnabled()) {
					System.out.println("Element Found");
				}
				return linkElement;
			}
		});
		element.click();

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
