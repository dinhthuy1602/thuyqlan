package com.viettel.qlan.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class DateUtil {

    private static Logger logger = Logger.getLogger(DateUtil.class);

//    public static final SimpleDateFormat DATE_FORMATTER_MMDD = new SimpleDateFormat("MMdd");
//    
//    public static final SimpleDateFormat DATE_FORMATTER_YYMMDD = new SimpleDateFormat("yyMMdd");
//    
//    public static final SimpleDateFormat DATE_FORMATTER_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
//    
//    public static final SimpleDateFormat DATE_FORMATTER_HHMM = new SimpleDateFormat("HHmm");
//    
//    public static final SimpleDateFormat DATE_FORMATTER_HHMMSS = new SimpleDateFormat("HHmmss");
//    
//    public static final SimpleDateFormat DATE_FORMATTER_SLASH_MMDDYYYY = new SimpleDateFormat("MM/dd/yyyy");
//    
//    public static final SimpleDateFormat DATE_FORMATTER_SLASH_DDMMYYYY = new SimpleDateFormat("dd/MM/yyyy");
//    
//    public static final SimpleDateFormat FACEBOOK_DATETIME = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//    
//    public static final SimpleDateFormat GOOGLE_DATE = new SimpleDateFormat("yyyy-MM-dd");
//    
//    public static final SimpleDateFormat GOOGLE_DATETIME = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    public static String dateToString(Date date, SimpleDateFormat formatter) {
        if (date == null) {
            return null;
        }

        return formatter.format(date);
    }

    public static Date stringToDate(String sDate, SimpleDateFormat formatter) {
        if (sDate == null) {
            return null;
        }

        Date date = null;

        try {
            date = formatter.parse(sDate);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return date;
    }

    public static Date getStartOfDay(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String sDate = formatter.format(d);
        Date dateStartOfDay = d;

        try {
            dateStartOfDay = formatter.parse(sDate);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return dateStartOfDay;
    }

    public static Date getEndOfDay(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String sDate = formatter.format(d);
        Date dateEndOfDay = d;
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            dateEndOfDay = formatter1.parse(sDate);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return dateEndOfDay;
    }

    public static Integer getIntCurrentDateByFormat(SimpleDateFormat formatter) {
        Date currentDate = new Date();
        Integer d = Integer.parseInt(formatter.format(currentDate));
        return d;
    }

    public static long getCurrentTimestamp() {
        Date currentDate = new Date();
        return currentDate.getTime();
    }

    public static String getCurrentDateTime() {
        Date dt = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);

        return currentTime;
    }

    public static String convertTimeDisplay(Date date) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return df.format(date);
    }

    public static String getSqlDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sDate = sdf.format(date);

        return sDate;
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);

        return cal.getTime();
    }

    public static Date addMonths(Date date, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);

        return cal.getTime();
    }

    public static Date addYears(Date date, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);

        return cal.getTime();
    }

    public static Date convertSqlDateToDate(String sDate) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            date = sdf.parse(sDate);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }

        return date;
    }

    public static double getDiffDays(Date fromDate, Date toDate) {

        long diff = toDate.getTime() - fromDate.getTime();
        double diffDays = (double) diff / 86400000;

        return diffDays;
    }

    public static double getDiffHours(Date fromDate, Date toDate) {

        long diff = toDate.getTime() - fromDate.getTime();
        double diffHours = (double) diff / 3600000; // 60 * 60 * 1000

        return diffHours;
    }

    public static double getDiffMinutes(Date fromDate, Date toDate) {

        long diff = toDate.getTime() - fromDate.getTime();
        double diffMinutes = (double) diff / 60000; // 60 * 1000

        return diffMinutes;
    }

    public static double getDiffSeconds(Date fromDate, Date toDate) {

        long diff = toDate.getTime() - fromDate.getTime();
        double diffSeconds = (double) diff / 1000; // 1000

        return diffSeconds;
    }

    public static Long convertToTimeStamp(String strDateTime, SimpleDateFormat formatter) {

        if (StringUtils.isEmpty(strDateTime)) {
            return null;
        }

        Long timeStamp = null;

        try {
            Date date = formatter.parse(strDateTime);
            timeStamp = date.getTime();
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        return timeStamp;
    }

    public static String formatDate(String date) throws ParseException {

        Date initDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String parsedDate = formatter.format(initDate);
        return parsedDate;
    }

    public static String formatDateVN(String date) throws ParseException {

        Date initDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String parsedDate = formatter.format(initDate);
        return parsedDate;
    }

//    public static String formatLongtoDateString (Long time ){
//        String date =null;
//        if(time !=null && time > 0){
//            try {
//                Date d = new Date(time);
//                date = DateUtil.dateToString(d, DateUtil.GOOGLE_DATE);
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//            }
//            
//        }
//        return date;
//    }
}
