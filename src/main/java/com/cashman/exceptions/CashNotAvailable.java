package com.cashman.exceptions;

public class CashNotAvailable extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}

	public CashNotAvailable(String errorMessage) {
		super(errorMessage);
		this.errorMessage=errorMessage;
	}

	public CashNotAvailable() {
		super();
	}
}
