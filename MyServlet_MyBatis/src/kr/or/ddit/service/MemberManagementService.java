package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.MemberManagementVO;

public interface MemberManagementService {
	
	List<MemberManagementVO> memberAllListPrint() throws SQLException;
	
	public int memberInfoInsert(MemberManagementVO mv) throws SQLException;

	public int memberInfoUpdate(MemberManagementVO mv) throws SQLException;
	
	public int memberInfoDelete(MemberManagementVO mv) throws SQLException;
	
	public MemberManagementVO getMemberInfo(String id) throws SQLException;
	
	public boolean checkMember(MemberManagementVO mv) throws SQLException;
	
	
}
