package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {
	public static void main(String[] args) throws InterruptedException {
		googleSearch();
	}
	
	public static void googleSearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://google.com");
	
		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		Thread.sleep(2000); //arr�t de deux s�condes pour voir ce qui se passe
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN); //permet d'apputer sur la touche "Entr�e"
		Thread.sleep(2000);
		driver.close();
		driver.quit();


	}
	

}
