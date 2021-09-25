package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.homepagesearchui;
import com.urbanladder.uistore.signupui;

public class signinpageobject {
	public static void search(WebDriver driver, String email,String password, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		ReusableMethods.sendKeys(signupui.email, email, driver);
		ReusableMethods.sendKeys(signupui.password, password, driver);
		Thread.sleep(10000);
		ReusableMethods.click(signupui.click, driver);
		
		
	}
	

}
