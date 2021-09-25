package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.homepagesearchui;
import com.urbanladder.uistore.trackorderui;

public class trackorderpageobject {

		public static void track(WebDriver driver, String data,String data2 ,Logger log) throws InterruptedException {
			// TODO Auto-generated method stub
			ReusableMethods.click(trackorderui.track, driver);
			ReusableMethods.sendKeys(trackorderui.orderno, data, driver);
			ReusableMethods.sendKeys(trackorderui.phoneno, data2, driver);
			ReusableMethods.click(trackorderui.submit, driver);
		}
		
}


