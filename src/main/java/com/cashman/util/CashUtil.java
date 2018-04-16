package com.cashman.util;

import org.springframework.stereotype.Component;

@Component("cashUtil")
public class CashUtil {
	
	public int strToInt(String val) {
		int intVal = Integer.parseInt(val);
		return intVal;
	}
	
	public int sum(String val) {
		String [] values = val.split(",");
		int sum=0;
		
		for(String value:values) {
			sum = sum + strToInt(value);
		}
		
		return sum;
	}
	
	public int sub(int val1,int val2) {
		
		return val1-val2;
	}
}
