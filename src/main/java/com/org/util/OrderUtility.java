package com.org.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtility {
	public String convertDate(Long orderTime){
		Date date = new Date(orderTime * 1000L);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//	format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = format.format(date);
		return formatted;
	}
	
}
