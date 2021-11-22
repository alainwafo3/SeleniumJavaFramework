import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Je n'ai pas bien compris l'intérêt fais plus de recherches
		//Voir cette vidéo youtube https://www.youtube.com/watch?v=UJDxewGXu7o
		// Visitez ces sites https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/remote/DesiredCapabilities.html  et  https://github.com/SeleniumHQ/selenium/wiki/DesiredCapabilities 

		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);

		//System.out.println("OS Name :"+System.getProperty("os.name"));
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		@SuppressWarnings("deprecation")
		WebDriver driver= new ChromeDriver (caps);

		driver.get("https://google.com");
 
		if(driver.findElement(By.id("L2AGLb")).getText().contains("accepte")) {
			System.out.println("Cookies");
			driver.findElement(By.id("L2AGLb")).click();
		}

		driver.findElement(By.name("q")).sendKeys("ABCD");
		//Thread.sleep(2000); //arrêt de deux sécondes pour voir ce qui se passe
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//driver.findElement(By.name("btnk")).click();
		//driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN); //permet d'apputer sur la touche "Entrée"
		//Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}