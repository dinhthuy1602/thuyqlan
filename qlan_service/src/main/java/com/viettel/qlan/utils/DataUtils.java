package com.viettel.qlan.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtils {

    private static Logger logger = LoggerFactory.getLogger(DataUtils.class);

    public static Date getSysDate(EntityManager em){
        try{
            String sql = "select now()";
            String result = em.createNamedQuery(sql).getSingleResult().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(result);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static Long parseBigDecimal(Object object){
        if(object == null)
            return null;
        if(object instanceof BigDecimal)
            return ((BigDecimal)object).longValue();
        return null;
    }
    public static int matchIp(String ip, String ipRegex) {
        if ( (ip == null) || (ip.length() < 1)|| (ipRegex == null)|| (ipRegex.length() < 2)) {
            return 3;
        }
        int iResult = validateIpRegex(ipRegex);
        if (iResult != 0) {
            return iResult;
        }
        String[] regexes = ipRegex.split("\\|");
        int check=0;
        for (int i = 0; i < regexes.length; i++) {
            String regex = regexes[i];
            String[] octets = regex.split("\\.");
            String[] ots = ip.split("\\.");
            if ((octets.length != 4) || (ots.length != 4)) {
                return 3;
            }
            if (((ots[0] + ots[1] + ots[2]).equalsIgnoreCase(octets[0] + octets[1] + octets[2])) && (matchOctet(ots[3], octets[3]) == 0)) {
            	++check;
            }
        }
        if(check>0){
        	return 0;
        } else {
        	return 1;
        }
    }

    public static int validateIpRegex(String ipRegex) {
        if ((ipRegex == null) || (ipRegex.length() < 1))
            return 3;
        int iResult = validateCharacters(ipRegex);
        if (iResult != 0) {
            return iResult;
        }

        if ((ipRegex.charAt(0) == '|') || (ipRegex.charAt(ipRegex.length() - 1) == '|'))
            return 3;
        String[] regexes = ipRegex.split("\\|");
        for(int i=0;i<regexes.length;i++) {
                String regex = regexes[i];
                if (regex == null || regex.length() < 1) {
                    return 3;
                }
                if (regex.charAt(0) == '.' || regex.charAt(regex.length() - 1) == '.') {
                    return 3;
                }
                String[] octets = regex.split("\\.");
                if (octets.length != 4) {
                    return 3;
                }
                if (validateOctet(octets[0]) != 0 || validateOctet(octets[1]) != 0 || validateOctet(octets[2]) != 0) {
                    return 3;
                }
                if (validateOctetRegex(octets[3]) != 0) {
                    return 3;
                }
             }
        return 0;
    }
    public static int validateOctet(String octet){
        if(octet==null||octet.length()==0)
            return 3;
        if(octet.length()>1 && octet.charAt(0)=='0')
            return 3;
        int value =-1;
        try{
            value=Integer.parseInt(octet);
        }catch (Exception e){
            return 3;
        }
        if(value<0||value>255)
            return 1;
        return 0;
    }
    
    public static int validateCharacters(String ipRegex){
        String expresstion="^[0-9\\.,*\\[\\]\\|-]*$";
        Pattern pattern =Pattern.compile(expresstion);
        Matcher matcher=pattern.matcher(ipRegex);
        return  matcher.matches() ? 0:2;
    }

    public static int matchOctet(String octet,String octetRegex){
       if("*".equalsIgnoreCase(octetRegex))
        return 0;
       if((octetRegex.charAt(0)=='[')&&(octetRegex.charAt(octetRegex.length()-1)==']')) {
           octetRegex = octetRegex.substring(1, octetRegex.length() - 1);
           int pos = octetRegex.indexOf('-');
           if (pos > 0) {
               String[] nums = octetRegex.split("-");
               try {
                   int begin = Integer.parseInt(nums[0]);
                   int end = Integer.parseInt(nums[1]);
                   int value = Integer.parseInt(octet);
                   if (value >= begin && value <= end) {
                       return 0;
                   }
               } catch (Exception e) {
                   return 1;
               }
           } else {
               String[] nums = octetRegex.split(",");
               for (int i = 0; i < nums.length; i++) {
                   String num = nums[i];
                   if (num.equalsIgnoreCase(octet)) {
                       return 0;
                   }
               }
           }
       }else if(octetRegex.equalsIgnoreCase(octet))
           return 0;
       return 1;
    }
    public static int validateOctetRegex(String octetRegex){
        if(octetRegex==null || octetRegex.length()<1)
            return 3;
        if(!octetRegex.equalsIgnoreCase("*")){
            if((octetRegex.charAt(0)=='[')&&(octetRegex.charAt(octetRegex.length()-1)==']')){
                octetRegex=octetRegex.substring(1,octetRegex.length()-1);
                if(octetRegex.length()<1)
                    return 3;
                int pos = octetRegex.indexOf('-');
                if(pos>=0){
                    if((octetRegex.charAt(0)=='-')||octetRegex.charAt(octetRegex.length()-1)=='-'){
                        return 3;
                    }
                    String[] nums=octetRegex.split("-");
                    if(nums.length!=2)
                        return 3;
                    if(validateOctet(nums[0])!=0||validateOctet(nums[1])!=0){
                        return 3;
                    }
                    try{
                        int begin =Integer.parseInt(nums[0]);
                        int end =Integer.parseInt(nums[1]);
                        if(begin>=end)
                            return 3;
                    }catch (Exception e){
                        return 3;
                    }
                }
                else{
                    if(octetRegex.charAt(0)==','||octetRegex.charAt(octetRegex.length()-1)==','){
                        return 3;
                    }
                    String[] nums=octetRegex.split("-");
                    if(nums.length!=2)
                        return 3;
                    for(int j =0;j<nums.length;j++){
                        String num = nums[j];
                        if(validateOctet(num)!=0)
                            return 3;
                    }
                }

            }
            else if(validateOctet(octetRegex)!=0)
                return 3;
        }
        return 0;
    }
    public static String parseStringData(Object object){
        if(object == null)
            return null;
        if(object instanceof BigDecimal)
            return ((BigDecimal)object).toString();
        return null;
    }
    public static boolean safeEqual(String obj1, String obj2){
        return obj1 == obj2 ? true:obj1!= null && obj2 != null && obj1.equals(obj2);
    }

    public static boolean safeEqual(Long obj1, Long obj2){
        return obj1 == obj2 ? true:obj1!= null && obj2 != null && obj1.compareTo(obj2) == 0;
    }
}