package com.cashman.project.cashman.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashman.exceptions.AmountCannotDispensed;
import com.cashman.exceptions.CashNotAvailable;
import com.cashman.helper.CashHelper;
import com.cashman.model.Notes;
import com.cashman.model.NotesInventry;
import com.cashman.project.cashman.service.CashmanService;
import com.cashman.util.CashUtil;

@Service("cashman")
public class CashmanServiceImpl implements CashmanService {

	@Autowired
	NotesInventry notesInventry;
	
	@Autowired
	CashUtil cashUtil;
	
	@Autowired
	CashHelper cashHelper;
	
	@Override
	public void addCash(Notes notes) {
		notesInventry.setTwenty( notes.getTwenty() + notesInventry.getTwenty());
		notesInventry.setFifty( notes.getFifty() +notesInventry.getFifty() );
		
		System.out.println(notesInventry);
		
	}
	
	@Override
	public NotesInventry cashAvailable() {
		NotesInventry notesInvlocal=new NotesInventry();
		notesInvlocal.setFifty(notesInventry.getTwenty());
		notesInvlocal.setTwenty(notesInventry.getFifty());
		System.out.println(notesInvlocal);
		
		return notesInvlocal;
	}	

	@Override
	public void withdrawCash(Notes notes) throws CashNotAvailable{
		
		NotesInventry notesInvVar=new NotesInventry();
		notesInvVar=cashAvailable();
		
		if(notesInvVar.getFifty()>=notes.getFifty() && notesInvVar.getTwenty()>=notes.getTwenty()) {
			notesInventry.setTwenty(cashUtil.sub(notesInventry.getTwenty(),notes.getTwenty()));
			notesInventry.setFifty(cashUtil.sub(notesInventry.getFifty(),notes.getFifty()));
		}
		else {
			throw new CashNotAvailable("Cash not avaiable");
		}
	}
	

	@Override
	public NotesInventry withdrawAmount(String var) throws AmountCannotDispensed, CashNotAvailable{

		int cash = cashUtil.strToInt(var);

		int fifty;
		int twenty;
		if (cash % 10 == 0) {
			l2: for (int i = 0; i <= Math.round(cash / 50); i++) {
				l1: for (int j = 0; j <= Math.round(cash / 20); j++) {
					if ((50 * i + 20 * j) == cash) {
						System.out.println("no of 50 " + i);
						System.out.println("no of 20 " + j);

						Notes notes = new Notes();
						notes.setFifty(i);
						notes.setTwenty(j);
						System.out.println("notes:" + notes);

						if (cashHelper.withdraw(notes)) {
							withdrawCash(notes);
						}

					}
				}
			}
		} 
		else {
			throw new AmountCannotDispensed("Amount cannot be dispensed");
		}
		return notesInventry;
	}

}
