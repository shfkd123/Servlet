package member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import member.util.SqlMapClientUtil;
import member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	// 사용할 DAO의 객체변수를 선언한다.
	private IMemberDao memDao;
	private SqlMapClient smc;

	public static IMemberService service;

	private MemberServiceImpl() {
		memDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}

	public static IMemberService getInstance() {
		if (service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}


	@Override
	public boolean checkMember(MemberVO mv) {
		boolean chk = false;

		try {
			chk = memDao.checkMember(smc, mv);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return chk;
	}

	@Override
	public MemberVO getMember(MemberVO mv) {
		MemberVO mv2 = null;
		
		try {
			mv2 = memDao.getMember(smc, mv);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return mv2;
	}

}
