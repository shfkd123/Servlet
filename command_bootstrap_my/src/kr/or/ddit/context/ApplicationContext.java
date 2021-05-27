package kr.or.ddit.context;

import java.util.HashMap;
import java.util.Map;

//Container - Map 형태
public class ApplicationContext {
	private static Map<String, Object> applicationContext = new HashMap<String, Object>();
	
	private ApplicationContext() {
		
	}
	
	public static Map<String, Object> getApplicationContext() {
		return applicationContext;
	}
	
	
}
