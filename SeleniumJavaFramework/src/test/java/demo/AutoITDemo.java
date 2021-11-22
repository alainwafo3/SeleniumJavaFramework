package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//https://www.youtube.com/watch?v=3nPFjfpDwGU&list=PLhW3qG5bs-L8oRay6qeS70vJYZ3SBQnFa&index=36&t=1085s
//Telechargement de fichier avec AutoIT

public class AutoITDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.filehosting.org/");
		Thread.sleep(3000);
		//driver.findElement(By.name("upload_file")).click();
		//driver.findElement(By.xpath("//input[@type='file']")).click();
		//driver.findElement(By.name("upload_file")).clear();
		driver.findElement(By.name("upload_file")).sendKeys("E:\\Downloads\\CNI WAFO David.pdf");
		//driver.findElement(By.name("uploader_email")).sendKeys("alainwafo3@gmail.com");

		//driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/input")).click();
		//*[@id="form"]/div/div/div[1]/input
		//*[@id="form"]/div/div/div[1]/input
		//*[@id="form"]/div/div/div[1]/input
		Thread.sleep(5000);

		//Runtime.getRuntime().exec("E:\\Selenium\\FileHostingScript.exe");

		Thread.sleep(5000);
		driver.close();
		System.out.println("bonjour");
	}
}
