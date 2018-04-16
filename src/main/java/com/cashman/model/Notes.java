package com.cashman.model;


public class Notes {

	private int twenty;
	private int fifty;

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	@Override
	public String toString() {
		return "Notes [twenty=" + twenty + ", fifty=" + fifty + "]";
	}

}
