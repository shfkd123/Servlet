package com.spring.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.josephoconnell.html.HTMLInputFilter;

public class XSSInterceptor extends HandlerInterceptorAdapter{

	@Override    //preInterceptor는 controller에 들어오기 직전 상태 파싱된  request
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Enumeration<String> crossParamNames = request.getParameterNames();
		
		while(crossParamNames.hasMoreElements()) {
			String paramName = crossParamNames.nextElement();
			String paramValue = request.getParameter(paramName);
			
			request.setAttribute("XSS"+paramName, HTMLInputFilter.htmlSpecialChars(paramValue));
		}
		return true;
	}

}
