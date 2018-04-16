package com.cashman.project.cashman;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cashman.model.Notes;
import com.cashman.model.NotesInventry;
import com.cashman.project.cashman.controller.CashmanController;
import com.cashman.project.cashman.service.CashmanService;
import com.cashman.util.CashUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CashmanApplicationTests {

	@MockBean
	CashmanController cashmanController;
	
	@Autowired
	NotesInventry notesInventry;
	
	@Resource(name="cashman")
	CashmanService cashmanService;
	
	@Autowired
	CashUtil cashUtil;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void addCash() throws Exception {
		Notes notes = new Notes();
		notes.setFifty(20);
		notes.setTwenty(40);
		
		cashmanService.addCash(notes);
		System.out.println("<=>"+notesInventry);
		assertEquals(notesInventry.getTwenty()+notesInventry.getFifty(), cashUtil.strToInt(Integer.toString(notes.getTwenty()))+cashUtil.strToInt(Integer.toString(notes.getFifty())));
	}

	@Test
	public void withdrawCashMethod() throws Exception {
		Notes notes = new Notes();
		notes.setFifty(10);
		notes.setTwenty(10);
		
		cashmanService.withdrawCash(notes);
		
		assertEquals(40, notesInventry.getTwenty()+notesInventry.getFifty());
	}


}
