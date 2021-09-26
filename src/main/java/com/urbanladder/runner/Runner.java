package com.urbanladder.runner;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pageobjects.Homepagesearchpageobject;
import com.urbanladder.pageobjects.addtocartpageobject;
import com.urbanladder.pageobjects.cartpageobject;
import com.urbanladder.pageobjects.customerStoriesPageObject;
import com.urbanladder.pageobjects.giftcardpageobject;
import com.urbanladder.pageobjects.loginpageobject;
import com.urbanladder.pageobjects.qandapageobject;
import com.urbanladder.pageobjects.signinpageobject;
import com.urbanladder.pageobjects.subscriptionpageobject;
import com.urbanladder.pageobjects.trackorderpageobject;
import com.urbanladder.reusablecomponents.ReusableComponents;
import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.utility.ExcelReader;
import com.urbanladder.utility.ExtentReport;
import com.urbanladder.utility.Log;
import com.urbanladder.utility.PropertyFileReader;

public class Runner {
	private ExtentReports report = ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(Runner.class.getName());
	WebDriver driver;

	@BeforeMethod
	void testing() throws IOException {
		driver = ReusableComponents.loadDriver();
	}

	@Test(priority = 0, dataProvider = "getTestData")
	void addtocart(String data) throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Adding to cart Validation");
		addtocartpageobject.search(driver, data, log);
		log.info("Product has been successfully added to cart");
		ReusableMethods.TakeScreenShot(driver, "addtocart");
		extentTest.pass("Adding to cart section passed");

	}

	@Test(priority = 1)
	void cart() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("cart page");
		cartpageobject.track(driver, log);
		log.info("Cart has beem successfully checked");
		ReusableMethods.TakeScreenShot(driver, "cart");
		extentTest.pass("Cart page passed");
	}

	@Test(priority = 2)
	void customerStories() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Customer Stories");
		customerStoriesPageObject.cs(driver, log);
		log.info("Successfully validated Customer Stories page");
		ReusableMethods.TakeScreenShot(driver, "Customer Stories");
		extentTest.pass("Customer stories page is passed");
	}

	@Test(priority = 3)
	void giftcard() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Gift Card page");
		giftcardpageobject.gift(driver, PropertyFileReader.loadFile().getProperty("data4"), log);
		log.info("Successfully validated giftcard page");
		ReusableMethods.TakeScreenShot(driver, "Gift Card");
		extentTest.pass("Gift card Page is passed");
	}

	@Test(priority = 4, dataProvider = "getTestData")
	void homepagesearch(String data) throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Homepage Validation");
		Homepagesearchpageobject.search(driver, data, log);
		log.info("Product has been successfully searched and the product name has been validated");
		ReusableMethods.TakeScreenShot(driver, "Home Page");
		extentTest.pass("Home Page is passed");
	}

	@Test(priority = 5)
	void login() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("login page");
		loginpageobject.login(driver, PropertyFileReader.loadFile().getProperty("email"),
				PropertyFileReader.loadFile().getProperty("password"), log);
		log.info("Successsfully automated login page");
		ReusableMethods.TakeScreenShot(driver, "Login page");
		extentTest.pass("Login page passed");
	}

	@Test(priority = 6)
	void qapage() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("QA page");
		qandapageobject.qa(driver, PropertyFileReader.loadFile().getProperty("data"),
				PropertyFileReader.loadFile().getProperty("data2"), log);
		log.info("QA page has been successfully validated");
		ReusableMethods.TakeScreenShot(driver, "QA page");
		extentTest.pass("QA page passed");
	}

	@Test(priority = 7)
	void signup() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Signup page");
		signinpageobject.search(driver, PropertyFileReader.loadFile().getProperty("email"),
				PropertyFileReader.loadFile().getProperty("password"), log);
		log.info("Signup page has been successfully automated");
		ReusableMethods.TakeScreenShot(driver, "Sign up");
		extentTest.pass("Sign up page passed");
	}

	@Test(priority = 8)
	void subscription() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Subscription");
		subscriptionpageobject.subscription(driver, PropertyFileReader.loadFile().getProperty("email"),
				PropertyFileReader.loadFile().getProperty("data3"), log);
		log.info("Mail Id is successfully added to subscription");
		ReusableMethods.TakeScreenShot(driver, "Subscription");
		extentTest.pass("Subscription page passed");
	}

	@Test(priority = 9)
	void track() throws IOException, InterruptedException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		extentTest = report.createTest("Trackorder Validation");
		trackorderpageobject.track(driver, PropertyFileReader.loadFile().getProperty("orderno"),
				PropertyFileReader.loadFile().getProperty("phonenumber"), log);
		log.info("Tracking page has been successfully validated");
		ReusableMethods.TakeScreenShot(driver, "Track order page");
		extentTest.pass("Track page passed");
	}

	@BeforeTest
	@DataProvider(name = "getTestData")
	public Object[][] getTestData() {
		Object[][] data = null;
		try {
			data = ExcelReader.readExcel();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@AfterMethod
	void clean() {

		report.flush();
		driver.close();
	}

}
