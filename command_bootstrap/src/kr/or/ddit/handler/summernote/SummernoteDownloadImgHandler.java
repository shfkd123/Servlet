package kr.or.ddit.handler.summernote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.FileDownloadResolver;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.utils.GetUploadPath;

public class SummernoteDownloadImgHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면은 없다. 
		String url = null;
		
		//파일명
		String fileName = request.getParameter("fileName");
		
		//실제 저장  경로를 설정
		String savePath = GetUploadPath.getUploadPath("summernote.img");
		
		FileDownloadResolver.sendFile(fileName, savePath, request, response); //파일이름과 경로를 받는다.  
		
		return url;
	}

	
}
