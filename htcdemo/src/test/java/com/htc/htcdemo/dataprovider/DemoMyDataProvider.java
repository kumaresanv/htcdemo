package com.htc.htcdemo.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.htc.htcdemo.base.Base;
import com.htc.htcdemo.helpers.ExcelUtility;

public class DemoMyDataProvider extends Base{
	
	@DataProvider(name = "Democomponents"  )
	public static Object[][] dataProviderMethod1(Method method) throws Exception {
		Object[][] testDataArray = null;
		ExcelUtility.setExcelFile(config.properties.get("testDataFilesPath")+config.properties.get("testDataFile"), "Democomponents");
		/*Test method name and value in test data should be same(value highlighted)*/
		testDataArray = ExcelUtility.getTestData(method.getName());
		return testDataArray;
	}	
}

