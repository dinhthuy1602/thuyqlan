package com.viettel.qlan.utils;

import java.util.ResourceBundle;

public class QlanResource {
private static ResourceBundle config;
public static synchronized ResourceBundle getConfig(){
	if(config==null){
		config=ResourceBundle.getBundle("lang_VI", new UTF8Control());
	}
	return config;
}

public static String get(String key){
	return getConfig().getString(key);
}
}
