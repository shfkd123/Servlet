package kr.or.ddit.handler.pds;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.AttachVO;
import kr.or.ddit.dto.PdsVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.PdsService;
import kr.or.ddit.utils.MakeFileName;

public class PdsModifyFormHandler implements Handler{

	private PdsService pdsService;
	public void setPdeService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url ="pds/modify";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		PdsVO pds = pdsService.getPds(pno);
		
		List<AttachVO> renameAttachList = MakeFileName.parseFileNameFromAttaches(pds.getAttachList(), "\\$\\$");
		pds.setAttachList(renameAttachList);
		
		request.setAttribute("pds", pds);
		return url;
	}

}
