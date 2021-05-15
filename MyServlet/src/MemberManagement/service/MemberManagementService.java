package MemberManagement.service;

import java.util.List;

import MemberManagement.dto.MemberManagementVO;

public interface MemberManagementService {

	//전체회원 리스트 출력
	public List<MemberManagementVO> memberAllListPrint();
	
	//회원정보 등록
	public int memberInfoInsert(MemberManagementVO mv);
	
	//회원정보 수정
	public int memberInfoUpdate(MemberManagementVO mv);
	
	//회원정보 삭제
	public int memberInfoDelete(MemberManagementVO mv);
	
	//회원정보 상세 조회
	public MemberManagementVO getMemberInfo(String memId);
	
	//주어진 회원ID가 존재하는지 판단 
	public boolean checkMember(MemberManagementVO mv);
}
