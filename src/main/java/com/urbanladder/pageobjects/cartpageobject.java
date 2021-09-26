package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.cartui;

public class cartpageobject {
	public static void track(WebDriver driver, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		ReusableMethods.click(cartui.cart, driver);
		Thread.sleep(1000);
		ReusableMethods.getAttributeonly(cartui.text, driver);
	}
}
