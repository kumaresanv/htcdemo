package com.htc.htcdemo.listener;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.htc.htcdemo.base.Base;
import com.htc.htcdemo.helpers.MyException;
import com.htc.htcdemo.pages.SeleniumEasyHomePage;

public class CustomListener extends Base implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		setDate();
		try {
			//setLog4j("TRRACS");trace
			setLog4j("SeleniumEasyDemo");
		} catch (MyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Log.info(suite.getName() + " : Test Suite Begins");
		try {
			gatherConfigProperties();
			initializeTestReport();
			
		} catch (MyException e) {
			Log.error("Failed To Gather Config Properties" + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		// getBrowser().quit();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		Log.info(getTestMethodName(testResult) + " : Test Case Passed");
		// getBrowser().quit();
			getTestCase().log(Status.PASS, MarkupHelper.createLabel(testResult.getName()+" PASSED ", ExtentColor.GREEN).getMarkup());
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		// TODO Auto-generated method stub
		Log.info(getTestMethodName(testResult) + " : Test Case Failed");
		try {
			getTestCase().log(Status.FAIL, testResult.getThrowable().getLocalizedMessage());
			getTestCase().log(Status.FAIL, MarkupHelper.createLabel(testResult.getName()+" FAILED ", ExtentColor.RED).getMarkup(), MediaEntityBuilder.createScreenCaptureFromPath(new File(snap.get().saveAs(testResult.getName() + ".png")).getAbsolutePath()).build());
		} catch (IOException | MyException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		// getBrowser().quit();
	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		// TODO Auto-generated method stub
		Log.info(getTestMethodName(testResult) + " : Test Case Skipped");
		try {
			getTestCase().log(Status.SKIP, MarkupHelper.createLabel(testResult.getName()+" FAILED ", ExtentColor.LIME).getMarkup(), MediaEntityBuilder.createScreenCaptureFromPath(new File(snap.get().saveAs(testResult.getName() + ".png")).getAbsolutePath()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getBrowser().quit();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info(context.getName() + " : Test Begins");
		try {
			try {
				trigger(typeOfBrowser, nameOfBrowser, driverFilesDirectory);
				getBrowser().get("https://www.seleniumeasy.com/test/");
				 setParentTestCase(extentReport.createTest(context.getCurrentXmlTest().getName()));
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				seleniumEasyHomePage = new SeleniumEasyHomePage(getBrowser());
			} catch (MyException e) {
				Log.error("Failed To Trigger Browser Session" + "\n" + e.getMessage());
				e.getMessage();
			}
		} catch (MalformedURLException e) {
			Log.error("Failed To Trigger Browser Session" + "\n" + e.getMessage());
			e.getMessage();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info(context.getName() + " : Test Ends");
		getBrowser().quit();
		extentReport.flush();
	}
	
	
	@AfterMethod
	public void after_each_test_case(ITestResult result) {
		Log.info(result.getMethod().getMethodName() + " : Test Case Ends");
		// getBrowser().quit();
	}

	private static String getTestMethodName(ITestResult testResult) {
		return testResult.getMethod().getConstructorOrMethod().getName();
	}

}

