package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.homepagesearchui;
import com.urbanladder.uistore.subscriptionUi;

public class subscriptionpageobject {
	public static void subscription(WebDriver driver, String email,String data3, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1200)", "");
	    Thread.sleep(1000);
		ReusableMethods.sendKeys( subscriptionUi.email, email, driver);
		Thread.sleep(1000);
		ReusableMethods.click(subscriptionUi.button, driver);
		Thread.sleep(1000);
		ReusableMethods.getAttributeqa(subscriptionUi.text, data3, driver);
	}
}
