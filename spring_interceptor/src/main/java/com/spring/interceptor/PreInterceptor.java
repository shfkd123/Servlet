package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PreInterceptor extends HandlerInterceptorAdapter {

	@Override //controller에게 가기전에 request, response를 먼저 받는다 ==> 가공할 수 있다. 뭔가 부적합할 때 return false를 쳐서 controller에게 가지 못하게 한다. 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = true;
		String state = request.getParameter("state");
		
		if(state == null || !state.equals("go")) {
			response.sendRedirect(request.getContextPath());
			result = false; //controller 실행 안됨 -->pre_test가 실행되지 않고 ContextPath로  돌아간다. 
		}
		return result;
	}

//	@Override //controller가 다 실행 된 후 Model에 무언가 담을 때 그 무언가를 확인할 때 post를 사용한다. controller가 model에게 준 값을 우리는 ModelAndView를 받기 때문에 model에 담긴것과, 화면을 조작할 수 있게 된다. 마치 controller가 보낸것처럼 자연스럽게 플로우 가능
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		super.postHandle(request, response, handler, modelAndView);
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		
//		super.afterCompletion(request, response, handler, ex);
//	}

}
