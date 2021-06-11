package kr.or.ddit.handler.prod;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdCategoryHandler01 implements Handler {
	
	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}	

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "prod/category01";
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String sortType = request.getParameter("sortType");		
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);		
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		cri.setSortType(sortType);		
		cri.setCategory("운동화");
		
		Map<String,Object> dataMap=null;
		
		try {
			dataMap=prodService.getProdCategoryList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			e.printStackTrace();
			url=null;
		}		
		return url;
	}

}
