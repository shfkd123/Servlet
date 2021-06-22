package com.spring.command;

import com.spring.dto.ReplyVO;

public class ReplyModifyCommand extends ReplyRegistCommand{
	
	private int rno;

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	//현재 toReplyVO에는 rno가 없다.
	//그래서 이렇게 만들어 주었다.
	@Override
	public ReplyVO toReplyVO() {
		ReplyVO reply = super.toReplyVO();
		reply.setRno(this.rno);
		
		return reply;
	}
		
}
