package MemberManagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import MemberManagement.dto.MemberManagementVO;
import MemberManagement.util.SqlMapClientUtil;

public class MemberManagementDaoImpl implements MemberManagementDao {
	
	private static MemberManagementDao memDao;
	
	private MemberManagementDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static MemberManagementDao getInstance() {
		if(memDao == null) {
			memDao = new MemberManagementDaoImpl();
		}
		return memDao;
	}

	//전체 회원 리스트 출력
	@Override
	public List<MemberManagementVO> memberAllListPrint(SqlMapClient smc) throws SQLException {
		List<MemberManagementVO> memList = smc.queryForList("memberManagement.memberAllListPrint");
		return memList;
	}

	//회원 정보 등록
	@Override
	public int memberInfoInsert(SqlMapClient smc, MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("memberManagement.memberInfoInsert", mv);
		
		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	//회원정보 수정
	@Override
	public int memberInfoUpdate(SqlMapClient smc, MemberManagementVO mv) throws SQLException {
		int cnt = 0;
		
		cnt = smc.update("memberManagement.memberInfoUpdate", mv);
		
		return cnt;
	}

	//회원정보 삭제
	@Override
	public int memberInfoDelete(SqlMapClient smc, MemberManagementVO mv) throws SQLException {
		
		int cnt = smc.delete("memberManagement.memberInfoDelete", mv);
		
		return cnt;
	}

	//회원정보 상세조회
	@Override
	public MemberManagementVO getMemberInfo(SqlMapClient smc, String memId) throws SQLException {
		MemberManagementVO mv = (MemberManagementVO)smc.queryForObject("memberManagement.getMemberInfo", memId);
		return mv;
	}

}
