package com.spring.command;

import java.util.Date;

import com.spring.dto.BoardVO;

public class BoardRegistCommand {

	private String title;
	private String writer;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "BoardRegistCommand [title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setContent(content);
		board.setTitle(title);
		board.setWriter(writer);
		board.setRegDate(new Date());
		
		return board;
		
	}
	
	
}
