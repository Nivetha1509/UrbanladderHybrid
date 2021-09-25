package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.qandaui;
import com.urbanladder.uistore.trackorderui;

public class qandapageobject {
	public static void qa(WebDriver driver, String data,String data2 ,Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		ReusableMethods.click(qandaui.qa, driver);
		Thread.sleep(1000);
		ReusableMethods.sendKeys(qandaui.searchbutton, data, driver);
		ReusableMethods.sendKeysArrowDown(qandaui.searchbutton, driver);
		ReusableMethods.sendKeysEnter(qandaui.searchbutton, driver);
		ReusableMethods.getAttributeqa(qandaui.text, data2, driver);
	}
}
