package MemberManagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import MemberManagement.dto.MemberManagementVO;
import member.vo.MemberVO;

public interface MemberManagementDao {
	
	//전체 회원 리스트 출력
	public List<MemberManagementVO> memberAllListPrint(SqlMapClient smc) throws SQLException;
	
	//회원 정보 등록
	public int memberInfoInsert(SqlMapClient smc, MemberManagementVO  mv) throws SQLException;
	
	//회원 정보 수정
	public int memberInfoUpdate(SqlMapClient smc, MemberManagementVO  mv) throws SQLException;
	
	//회원 정보 삭제
	public int memberInfoDelete(SqlMapClient smc, MemberManagementVO  mv) throws SQLException;
	
	//회원 정보 조회
	public MemberManagementVO getMemberInfo(SqlMapClient smc, String memId) throws SQLException;
	
	//회원이 존재하는지 여부 판단
	public boolean checkMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	
}
