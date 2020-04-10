package com.htc.htcdemo.pageobjects;

import org.openqa.selenium.By;

public interface SeleniumEasyPageObjects {

	//Top menuitems objects
		By mnu_InputForms = By.xpath("//div[@id='navbar-brand-centered']/ul/li/a[contains(text(),'Input Forms')]");
		By submnu_SimpleForm = By.xpath("//div[@id='navbar-brand-centered']/ul[1]/li[1]/ul[1]/li[1]/a[contains(text(),'Simple Form Demo')]");
		By submnu_SimpleForm1 = By.partialLinkText("Simple Form Demo");	
		//div[@id="navbar-brand-centered"]/ul[1]/li[1]/ul/li[1]/a
		
		By singleinput = By.id("user-message");
		By getinput = By.xpath("//form[@id='get-input']/button");
		
		By Inputverifytext = By.id("display");
		
		By sum1 = By.id("sum1");
		By sum2 = By.id("sum2");
		By BtnGetTotal = By.xpath("//form[@id='gettotal']/button");
		By getResultValue= By.id("displayvalue");
		
	
	
	
	
	/* Page objects using POM(page object model) */
	By usernameTxtbox = By.id("userName");
	By passwordTxtbox = By.id("password");
	By exportRadioBtn = By.xpath("//input[@value='edis']");
	By importRadioBtn = By.xpath("//input[@value='idis']");
	By loginBtn = By.id("loginBtn");
	By loginExpire = By.xpath("//span[text()='Yes']");
	By sessionExpire = By.xpath("//div[@id='welcome']/following::div[1]/button");
	
	/**************************************/
	/* Page objects using POM(page object model) */
	By USERNAME = By.id("userName");
	By PASSWORD = By.id("password");
	By EXPORTRADIOBUTTON = By.xpath("//input[@value='edis']");
	By IMPORTRADIOBUTTON = By.xpath("//input[@value='idis']");
	By LOGINBUTTON = By.id("loginBtn");
	By SESSIONEXPIRE = By.xpath("//div[@id='welcome']/following::div[1]/button");
	By LOGOUTBUTTON = By.xpath("//a[starts-with(text(),'Logout')]");
	By LOGINEXPIRE = By.xpath("//span[text()='Yes']");

}