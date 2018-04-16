package com.cashman.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cashman.model.Notes;
import com.cashman.model.NotesInventry;

@Component("cashHelper")
public class CashHelper {
	
	@Autowired
	NotesInventry notesInventry;
	
	public boolean withdraw(Notes notes) {

		if (notesInventry.getFifty() >= notes.getFifty()
				&& notesInventry.getTwenty() >= notes.getTwenty()) {
			return true;
		} else {
			return false;
		}
	}

}
