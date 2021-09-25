package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.*;
import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.homepagesearchui;

public class Homepagesearchpageobject {


		public static void search(WebDriver driver, String data, Logger log) throws InterruptedException {
			// TODO Auto-generated method stub
			ReusableMethods.sendKeys( homepagesearchui.search, data, driver);
			Thread.sleep(1000);
			ReusableMethods.click(homepagesearchui.searchbutton, driver);
			Thread.sleep(1000);
			ReusableMethods.getAttribute(homepagesearchui.text, data, driver);
		}
		
}
