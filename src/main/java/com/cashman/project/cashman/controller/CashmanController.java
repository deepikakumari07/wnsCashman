package com.cashman.project.cashman.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashman.exceptions.AmountCannotDispensed;
import com.cashman.exceptions.CashNotAvailable;
import com.cashman.exceptions.AmountCannotDispensed;
import com.cashman.exceptions.ErrorResponse;
import com.cashman.model.Notes;
import com.cashman.model.NotesInventry;
import com.cashman.project.cashman.service.CashmanService;

@RestController
@RequestMapping("/cash")
public class CashmanController {
	
	@Autowired
	NotesInventry notesInventry;
	
	@Resource(name="cashman")
	CashmanService cashmanService;
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
	public NotesInventry addCashMethod(@RequestBody Notes notes){
		cashmanService.addCash(notes);
		return notesInventry;
	}
	
	@RequestMapping(value = "/available", method = RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
	public NotesInventry cashAvailable(){
		cashmanService.cashAvailable();
		return notesInventry;
	}
	
	@RequestMapping(value= "/remove" , method=RequestMethod.DELETE , headers="Accept=application/json")
	@ResponseBody
	public NotesInventry withdrawCashMethod(@RequestBody Notes notes) throws CashNotAvailable {
		try {
			cashmanService.withdrawCash(notes);				
		}
		catch(CashNotAvailable e) {
			throw new CashNotAvailable("Cash not avaiable");
		}
		return notesInventry;
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/withdrawCash/{amount}", headers="Accept=application/json")
	public NotesInventry withdrawAmount(@PathVariable String amount) throws Throwable {
		//System.out.println("amount :"+amount);
		try {
			cashmanService.withdrawAmount(amount);
		}catch(Throwable e) {
			throw e;
		}
	return notesInventry;
	}
	
	@ExceptionHandler(AmountCannotDispensed.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
		
}
