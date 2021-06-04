package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.utils.MakeFileName;

public class FileDownloadResolver {

	public static void sendFile(String fileName, String savedPath, HttpServletRequest request,
			HttpServletResponse response) throws SecurityException, IOException {
		
		String filePath = savedPath + File.separator + fileName;
		
		//보낼 파일 설정
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		//파일을 내보낼 때에는 받는 애가 어떤 파일 종류를 받을 지 모르기 때문에 
		//헤더 세팅이 필요하다.
		//ServeltContext에는 헤더 세팅을 바로 해주는 MimeType 있기 때문에
		//request를 사용해서  ServeltContext를 꺼내고 거기에 filePath를 알려준다. 
		//
		//파일 포맷으로 MIME를 결정한다.
		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(filePath);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		
		//response 
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", 
				MakeFileName.parseFileNameFromUUID(downloadFile.getName(),"\\$\\$"));
		response.setHeader(headerKey, headerValue);
		
		//파일 내보내기
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		inStream.close();
		outStream.close();
		
	}
}
