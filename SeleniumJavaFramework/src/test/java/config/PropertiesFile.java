package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestING_Demo;

public class PropertiesFile {
	static Properties prop  = new Properties();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
		getProperties();

	}
	public static void getProperties() {
		try {
			InputStream input= new FileInputStream("src/test/java/config/config.properties");
			prop.load(input);
			String browser=prop.getProperty("browser");
			System.out.println(browser);
			TestING_Demo.browserName=browser;


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public static void setProperties() {
		try {
			OutputStream output= new FileOutputStream("src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

