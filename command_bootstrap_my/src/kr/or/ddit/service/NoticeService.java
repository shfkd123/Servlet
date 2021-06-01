package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.NoticeVO;

public interface NoticeService {
	
	List<NoticeVO> noticeList() throws SQLException;
}
