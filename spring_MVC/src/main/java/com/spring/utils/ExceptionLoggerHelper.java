package com.spring.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.spring.dto.MemberVO;

public class ExceptionLoggerHelper {
	
	public static void write(HttpServletRequest request, Exception e, Object res) {
		String savePath = GetUploadPath.getUploadPath("error.log").replace("/", File.separator);
		String logFilePath = savePath + File.separator + "system_exception_log.csv";

		String url = request.getRequestURI().replace(request.getContextPath(), "");
		String date = new SimpleDateFormat("yyyy-MM-dd : HH:mm").format(new Date());
		String loginUserName = ((MemberVO) request.getSession().getAttribute("loginUser")).getName();
		String excpetionType = e.getClass().getName();
		String happenObjcet = res.getClass().getName();

		String log = "[Error : " + excpetionType + "]" + url + "," + date + "," + loginUserName + "," + happenObjcet
				+ "\n" + e.getMessage();
		
		//로그 파일 생성
		File file = new File(savePath);
		file.mkdirs();
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath, true));
			
			//로그를 기록
			out.write(log);
			out.newLine(); //기록하고 한 줄 띄운다.
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
			
	}
}
