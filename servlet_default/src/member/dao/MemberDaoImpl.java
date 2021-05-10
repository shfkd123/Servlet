package member.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import member.util.SqlMapClientUtil;
import member.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{
	
	private static IMemberDao memDao;

	private MemberDaoImpl() {
		SqlMapClientUtil.getInstance();
	}

	public static IMemberDao getInstance() {
		if (memDao == null) {
			memDao = new MemberDaoImpl();
		}
		return memDao;
	}

	@Override // 회원이 존재하는지 여부를 알아내는 메서드
	public boolean checkMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		boolean chk = false; // 중복되면 false

		int cnt = (int) smc.queryForObject("member.checkMember", mv);

		if (cnt > 0) {
			chk = true; // 중복이 아니면 true
		}
		return chk;
	}

	@Override //회원 정보 조회
	public MemberVO getMember(SqlMapClient smc, MemberVO mv) throws SQLException {
		MemberVO mv2 = (MemberVO)smc.queryForObject("member.getMember", mv);
		return mv2;
	}

}
