package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


//http://phantomjs.org/
//https://www.youtube.com/watch?v=pJtBjvwb86E&list=PLhW3qG5bs-L8oRay6qeS70vJYZ3SBQnFa&index=34
//https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities
//https://sites.google.com/a/chromium.org/chromedriver/capabilities
//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/chrome/ChromeOptions.html
//Tap chromeoptions list on google and you will see
public class HeadlessChromeDemo {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920,1080");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://google.com");


		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}
		System.out.println("Title : "+driver.getTitle());

		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[@id=\"rso\"]/div[4]/div/div/div[1]/a/h3")).click();
		driver.close();
		driver.quit();
		System.out.println("Completed");
	}
}
