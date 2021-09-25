package com.urbanladder.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.urbanladder.reusablecomponents.ReusableMethods;
import com.urbanladder.uistore.homepagesearchui;
import com.urbanladder.uistore.loginpageui;

public class loginpageobject {
	public static void login(WebDriver driver, String email,String password, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement mainMenu = driver.findElement(By.cssSelector("#header > div.header__topBar > div > section.header__topBar_sectionRight > ul > li.header__topBarIconList_profile-icon > span > svg > path"));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(mainMenu);
	    WebElement subMenu = driver.findElement(By.xpath("//*[@id=\'header\']/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a"));
	    actions.moveToElement(subMenu);
	    actions.click().build().perform();
	    Thread.sleep(10000);
	    driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/input")).sendKeys(email);
	    //Password locator :
	    driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/div/div/input")).sendKeys(password);
	    driver.findElement(By.xpath("//*[@id=\"ul_site_login\"]")).click();
		
	}
}
