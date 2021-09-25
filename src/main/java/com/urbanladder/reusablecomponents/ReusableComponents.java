package com.urbanladder.reusablecomponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.urbanladder.utility.PropertyFileReader;

public class ReusableComponents {
	public static WebDriver driver;
	public static WebDriver loadDriver() {
		System.setProperty("webdriver.chrome.driver", PropertyFileReader.loadFile().getProperty("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ReusableMethods.timelapse(driver);
		return driver;
	}
}
