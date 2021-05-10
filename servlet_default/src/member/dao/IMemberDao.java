package member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import member.vo.MemberVO;

public interface IMemberDao {
	
	/**
	 * 회원이 존재하는지 여부를 알아내는 메서드
	 * @param smc
	 * @param mv
	 * @return 해당 회원이 존재하면 true, 존재하지 않으면 false
	 * @throws SQLException
	 */
	public boolean checkMember(SqlMapClient smc, MemberVO mv) throws SQLException;
	
	/**
	 * 회원 정보 조회
	 * @param smc SqlMapClient 객체
	 * @param mv
	 * @return
	 * @throws SQLException
	 */
	public MemberVO getMember(SqlMapClient smc, MemberVO mv) throws SQLException;
}
