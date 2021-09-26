package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.giftcardUi;

public class giftcardpageobject {
	public static void gift(WebDriver driver, String data4, Logger log) throws InterruptedException {
		ReusableMethods.click(giftcardUi.giftcard, driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		ReusableMethods.click(giftcardUi.chose, driver);
		ReusableMethods.click(giftcardUi.money, driver);
		ReusableMethods.sendKeysArrowDown(giftcardUi.date, driver);
		ReusableMethods.sendKeysEnter(giftcardUi.date, driver);
		ReusableMethods.getAttributeqa(giftcardUi.text, data4, driver);

	}
}
