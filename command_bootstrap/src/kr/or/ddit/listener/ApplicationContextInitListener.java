package kr.or.ddit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextInitListener implements ServletContextListener {

    
	//서블릿 컨텍스트가 초기화 되었을 때 호출
	public void contextInitialized(ServletContextEvent sce)  { 
		String param = sce.getServletContext().getInitParameter("testParam");
		System.out.println(param); 
	}

	//서블릿 컨텍스트가 제거되었을 때 호출
	public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }

	
}
