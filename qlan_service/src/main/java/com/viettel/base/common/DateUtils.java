package com.viettel.base.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
	
	public static String date2str(Date date, String format){
		SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
		return mdyFormat.format(date);
	}
	
	public static String date2str(Date date){
		SimpleDateFormat mdyFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		return mdyFormat.format(date);
	}
}



