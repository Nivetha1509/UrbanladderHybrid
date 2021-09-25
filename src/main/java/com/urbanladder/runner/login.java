package com.urbanladder.runner;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pageobjects.loginpageobject;
import com.urbanladder.reusablecomponents.ReusableComponents;
import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.utility.ExtentReport;
import com.urbanladder.utility.Log;
import com.urbanladder.utility.PropertyFileReader;

public class login {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(login.class.getName());
	WebDriver driver;
	@BeforeMethod
	void testing() throws IOException {
		 driver =  ReusableComponents.loadDriver();
		 
	}
	@Test
	void login() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
			extentTest = report.createTest("login page");
			loginpageobject.login(driver, PropertyFileReader.loadFile().getProperty("email"), PropertyFileReader.loadFile().getProperty("password"), log);	
			log.info("Successsfully automated login page");
			ReusableMethods.TakeScreenShot(driver, "Login page");
			extentTest.pass("Login page passed");
		}
	@AfterMethod
	void clean() {
		
		report.flush();
		driver.close();
	}
	
}
