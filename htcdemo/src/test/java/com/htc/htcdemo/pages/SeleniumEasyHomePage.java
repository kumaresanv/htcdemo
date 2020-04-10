package com.htc.htcdemo.pages;

import org.openqa.selenium.WebDriver;

import com.htc.htcdemo.base.BasePage;
import com.htc.htcdemo.helpers.MyException;
import com.htc.htcdemo.pageobjects.SeleniumEasyPageObjects;

public class SeleniumEasyHomePage extends BasePage implements SeleniumEasyPageObjects {

	public SeleniumEasyHomePage(WebDriver driver) throws MyException {
		super(driver);
	}
	
	public String getSeleniumEasyHomePageTitle() throws MyException {
		return getPageTitle();
	}
	
	public void clickTopMenuItem(String mnuItem) throws MyException {
		switch(mnuItem){
			case "Input Forms" : clickOn(mnu_InputForms);
			case "Date Picker" : clickOn(mnu_InputForms);
		}
	}
	public void clickSubMenuItem(String submnuItem) throws MyException, InterruptedException {
		switch(submnuItem){
			case "SimpleFormDemo" :
					//clickOn(submnu_SimpleForm);
					selectDropdownValue(mnu_InputForms,"Simple Form Demo");
		}
	//clickOn(submnu_SimpleForm);
	}
	public void enterSingleInput(String strSIngleInput) throws MyException {
		//clickOn(singleinput);
		type(strSIngleInput,singleinput);
	}
	public void clickInputButton() throws MyException {
		clickOn(getinput);		
	}
	public boolean VerifyEnteredValue(String strSingleInputvalue) throws MyException {
		boolean check=false;
		check=strSingleInputvalue.equalsIgnoreCase(getTextFrom(Inputverifytext));
		return check;
	}
	
	public boolean AddTwoNumberAndVerifyResult(String a,String b,String ExpectedValue) throws MyException {
		Boolean totalvalueMatches = true; 
		//Enter value for Field A
		  type(a,sum1);		  
		//Enter value for Field B
		  type(b,sum2);
		//Click the Get total button
		  clickOn(BtnGetTotal);
		//Verify the expected Value against actual value
		  getTextFrom(getResultValue);
		//convert string number value to number
		  int intA,intB,intSum,Expetedintvalue;
		  intSum = Integer.parseInt(a) + Integer.parseInt(b);
		  Expetedintvalue = Integer.parseInt(ExpectedValue);
		  if(intSum != Expetedintvalue) {
			  return totalvalueMatches=false;
		  }
		return totalvalueMatches;		  
	}
	
	// Logout seleniumEasyDemo
		public void logoutTrracs() throws MyException {
			try {
				clickOn(LOGOUTBUTTON);
				System.out.println("User logout successful");
			} catch (Exception e) {
				throw new MyException("Failed To Logout Trracs");
			}
		}

		

}
