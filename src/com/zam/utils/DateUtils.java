package com.zam.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String date) throws ParseException{
		
		Date parsedDate = formatter.parse(date);
		System.out.println("parsedDate : " + parsedDate.toString());
		
		return parsedDate;
	}
	
	public static String formatDate(Date date) {
		String formattedDate = null;
		
		if(date != null)
			formattedDate = formatter.format(date);
		
		System.out.println("formatted Date : " + formattedDate);
		
		return formattedDate;
	}
}
