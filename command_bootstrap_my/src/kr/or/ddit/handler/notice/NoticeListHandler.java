package kr.or.ddit.handler.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;

public class NoticeListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/list";
		
//		String page = request.getParameter("page");
//		String perPageNum = request.getParameter("perPageNum");
//		String searchType = request.getParameter("searchType");
//		String keyword = request.getParameter("keyword");
//		
//		SearchCriteria cri = new SearchCriteria();
//		cri.setPage(page);
//		cri
		return url;
	}

}
