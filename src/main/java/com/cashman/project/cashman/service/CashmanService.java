package com.cashman.project.cashman.service;

import com.cashman.exceptions.AmountCannotDispensed;
import com.cashman.exceptions.CashNotAvailable;
import com.cashman.model.Notes;
import com.cashman.model.NotesInventry;

public interface CashmanService {
	
	public void addCash(Notes notes);
	
	public NotesInventry cashAvailable();
	
	public void withdrawCash(Notes notes) throws CashNotAvailable;
	
	public NotesInventry withdrawAmount(String var) throws AmountCannotDispensed, CashNotAvailable;

}
