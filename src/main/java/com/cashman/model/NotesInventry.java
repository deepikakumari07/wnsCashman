package com.cashman.model;

import org.springframework.stereotype.Component;

@Component("notesInventry")
public class NotesInventry {

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
		return "NotesInventry [Twenty Notes=" + twenty + ", Fifty Notes=" + fifty + "]";
	}


}
