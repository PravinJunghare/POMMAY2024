package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionManager;
	public static String highlight;

	/**
	 * this method is used to initializing the driver on the basis of browsername
	 * 
	 * @param browserName
	 * @return the driver
	 */
	// public WebDriver initDriver(String browserName)
	public WebDriver initDriver(Properties prop) {

		optionManager = new OptionsManager(prop);
		highlight=prop.getProperty("highlight").trim();

		String browserName = prop.getProperty("browser").toLowerCase().trim();
		System.out.println("browser name is :" + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(optionManager.getChromeOptions());
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(optionManager.getFirefoxOptions());
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(optionManager.getEdgeOptions());
		} else {
			System.err.println("Please pass corrrect browsername" + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get(prop.getProperty("url"));
		return driver;
	}

	/**
	 * this method read the properties from .properties file
	 * 
	 * @return
	 */

	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;
	}

}
