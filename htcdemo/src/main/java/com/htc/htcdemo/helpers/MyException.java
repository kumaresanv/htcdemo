package com.htc.htcdemo.helpers;

@SuppressWarnings("serial")
public class MyException extends Exception {

	/* <---------- Throw My Own Exceptions ---------> */
	public MyException(String errorMessage) {
		super(errorMessage);
	}

}
