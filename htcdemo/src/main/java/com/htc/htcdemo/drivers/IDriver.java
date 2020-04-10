package com.htc.htcdemo.drivers;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.htc.htcdemo.helpers.MyException;

public interface IDriver {

	WebDriver launch(String browserName) throws MyException, MalformedURLException;

}