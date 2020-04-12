package com.htc.htcdemo.testcases;

import java.lang.reflect.Method;
import java.util.Map;
import static org.testng.Assert.assertNotNull;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.htc.htcdemo.base.Base;
import com.htc.htcdemo.dataprovider.DemoMyDataProvider;
import com.htc.htcdemo.helpers.MyException;
import com.htc.htcdemo.pages.SeleniumEasyHomePage;

public class SeleniumEasyHome extends Base {
	//Launch the selenium easy demo page and verify selenium easy demo page title
	//Added to test jenkin test
	@Test(dataProvider = "Democomponents", dataProviderClass = DemoMyDataProvider.class)
	public void TC01_VerifyPageTitle(Map<String, String> testData, Method method) throws MyException {
		setTestCase(getParentTestCase().createNode(method.getName()));
		System.out.println("testData user type" + testData.get("pageTitle"));
		String strCurrentPageTitle=null;
		strCurrentPageTitle = seleniumEasyHomePage.getSeleniumEasyHomePageTitle();
		//verify selenium easy demo page title
		Assert.assertEquals(strCurrentPageTitle,testData.get("pageTitle"));
		getTestCase().log(Status.INFO,  "Checked selenium page title");	
	}
	@Test(dataProvider = "Democomponents", dataProviderClass = DemoMyDataProvider.class)
	public void TC02_InputFormMsgTest(Map<String, String> testData, Method method) throws MyException, InterruptedException {
		setTestCase(getParentTestCase().createNode(method.getName()));			
		seleniumEasyHomePage.clickSubMenuItem(testData.get("SubMenuItem"));
		Thread.sleep(4000);
		seleniumEasyHomePage.enterSingleInput(testData.get("EnterMsg"));		
		getTestCase().log(Status.INFO,  "Single input value Entered and Submitted");		
	}
	@Test(dataProvider = "Democomponents", dataProviderClass = DemoMyDataProvider.class)
	public void TC03_VerifyInputFormMsgTxt(Map<String, String> testData, Method method) throws MyException, InterruptedException {
		setTestCase(getParentTestCase().createNode(method.getName()));	
		Thread.sleep(4000);
		seleniumEasyHomePage.clickInputButton();
		Thread.sleep(1000);
		Assert.assertTrue(seleniumEasyHomePage.VerifyEnteredValue(testData.get("VerifyInputText")));
		getTestCase().log(Status.INFO,  "Input value verified");		
	}
	@Test(dataProvider = "Democomponents", dataProviderClass = DemoMyDataProvider.class)
	public void TC04_AddToNumberAndVerifyResultTxt(Map<String, String> testData, Method method) throws MyException, InterruptedException {
		Boolean endresut=false;
		setTestCase(getParentTestCase().createNode(method.getName()));	
		Thread.sleep(4000);
		endresut=seleniumEasyHomePage.AddTwoNumberAndVerifyResult(testData.get("Enter A"),testData.get("Enter B"),testData.get("ExpectedResult"));
		Thread.sleep(3000);
		Assert.assertTrue(endresut);
		getTestCase().log(Status.INFO,  "Number input value Entered and verified");		
	}
	
}

