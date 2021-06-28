package com.spring.mail;

import java.io.File;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.spring.command.MailRequestCommand;

public class MimeAttachNotifier {
	
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(MailRequestCommand mail, String uploadPath)throws Exception {
		//메시지 생성
		MimeMessage message = mailSender.createMimeMessage();
		
		//메시지 작성헬퍼
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
		
		//받는 사람
		messageHelper.setTo(new InternetAddress(mail.getReceiver()));
		
		//보내는 사람
		messageHelper.setFrom(mail.getSender(), "운영자");
		
		//제목
		messageHelper.setSubject(mail.getTitle());
		
		//내용
		messageHelper.setText(mail.getContent(), true); //true는 HTML 순수한 text로 하고 싶으면 false
		
		//첨부파일
		if(mail.getFile() != null && !mail.getFile().isEmpty()) {
			String fileName = mail.getFile().getOriginalFilename();
			DataSource dataSource = new FileDataSource(new File(uploadPath, fileName));
			
			messageHelper.addAttachment(MimeUtility.encodeText(fileName, "utf-8", "B"), dataSource);
			//"B"는 Binary형식
		}
		mailSender.send(message); //위에서 만든거 보내줌. 
	}
}
 