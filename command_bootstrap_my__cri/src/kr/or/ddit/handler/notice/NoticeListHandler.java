package kr.or.ddit.handler.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.NoticeService;

public class NoticeListHandler implements Handler {
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "notice/list";
		
		List<NoticeVO> noticeList = noticeService.noticeList();
		
		request.setAttribute("noticeList", noticeList);
		
		return url;
	}

}
