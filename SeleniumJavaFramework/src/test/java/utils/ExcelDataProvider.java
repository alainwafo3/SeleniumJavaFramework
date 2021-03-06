package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;
import freemarker.core.ReturnInstruction.Return;

public class ExcelDataProvider {

	WebDriver driver=null;


	public static void main(String[] args) {
		String excelPath="excel/data.xlsx";
		String sheetName="Sheet1";
		testData( excelPath,  sheetName);

	}

	@BeforeTest
	public void setUpTest() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver= new ChromeDriver();


	}

	//les donn?es sont extraites depuis mon fichier excel

	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username+" | "+password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("welcome-menu")).click();

		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

	@DataProvider(name = "test1data")
	public  Object[][] getData() {
		String excelPath= "excel/data.xlsx";


		Object data [][]=testData(excelPath, "Sheet1");
		return data;

	}

	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel =new ExcelUtils( excelPath,  sheetName);

		int rowCount=excel.getRowCount();
		int colCount= excel.getColCount();

		Object data[][] = new Object[rowCount-1][colCount];

		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData= excel.getCellDataString(i,j);
				//System.out.print(cellData+" | ");
				data[i-1][j]=cellData;
			}
			System.out.println();

		}
		return data;

	}

}
