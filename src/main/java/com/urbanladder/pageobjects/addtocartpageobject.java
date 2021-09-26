package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.addtocartUi;

public class addtocartpageobject {
	public static void search(WebDriver driver, String data, Logger log) throws InterruptedException {
		ReusableMethods.sendKeys(addtocartUi.search, data, driver);
		ReusableMethods.click(addtocartUi.button, driver);
		ReusableMethods.click(addtocartUi.product, driver);
		ReusableMethods.click(addtocartUi.cart, driver);
	}

}
