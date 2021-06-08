package kr.or.ddit.handler.summernote;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.command.SummernoteDeleteImgCommand;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.utils.GetUploadPath;

public class SummernoteDeleteImgHandler implements Handler {

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String url = null;
      
      ObjectMapper mapper = new ObjectMapper();//Json 데이터를 파싱하기 위해 
      
      SummernoteDeleteImgCommand delReq = mapper.readValue(request.getReader(), SummernoteDeleteImgCommand.class);
      //json 데이터를 읽어서 인스턴스를 할당하고 그 인스턴스를 준다.
      
      String savePath = GetUploadPath.getUploadPath("summernote.img");
      String fileName = delReq.getFileName(); //파싱한 객체에 파일 이름이 들어가 있다. 
      
      fileName = URLDecoder.decode(fileName, "UTF-8"); //한글 파일 
      
      File target = new File(savePath + File.separator + fileName);
      
      response.setContentType("text/plain;charset=utf-8");
      
      PrintWriter out = response.getWriter();
      
      if(!target.exists()) {
         response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
         
      } else {
         target.delete();
         out.print(fileName + "이미지를 삭제했습니다.");
      }
      return url;
   }

}