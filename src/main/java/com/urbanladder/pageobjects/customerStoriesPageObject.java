package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.customerStoriesUi;
import com.urbanladder.uistore.homepagesearchui;

public class customerStoriesPageObject {
	public static void cs(WebDriver driver,  Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1200)", "");
	    Thread.sleep(1000);
		ReusableMethods.click( customerStoriesUi.cs,  driver);
		Thread.sleep(1000);
		ReusableMethods.image(customerStoriesUi.image, driver);
	}
}
