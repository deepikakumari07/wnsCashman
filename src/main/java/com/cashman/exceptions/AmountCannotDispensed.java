package com.cashman.exceptions;

public class AmountCannotDispensed extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public AmountCannotDispensed(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public AmountCannotDispensed() {
		super();
	}
}