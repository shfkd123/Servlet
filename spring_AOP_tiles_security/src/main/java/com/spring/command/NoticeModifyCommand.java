package com.spring.command;

import com.spring.dto.NoticeVO;

public class NoticeModifyCommand extends NoticeRegistCommand {

	private int nno;

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	@Override
	public NoticeVO toNoticeVO() {
		NoticeVO notice = super.toNoticeVO();
		notice.setNno(nno);
		return notice;
	}	
	
}
