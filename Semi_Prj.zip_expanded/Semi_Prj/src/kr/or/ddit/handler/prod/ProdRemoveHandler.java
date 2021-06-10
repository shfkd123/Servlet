package kr.or.ddit.handler.prod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdRemoveHandler implements Handler {
	

	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="prod/remove_success";
		
		String id = request.getParameter("id");
		
		prodService.remove(id);
		
		return url;
	}

}
