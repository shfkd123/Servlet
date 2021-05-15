package MemberManagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import MemberManagement.dao.MemberManagementDao;
import MemberManagement.dao.MemberManagementDaoImpl;
import MemberManagement.dto.MemberManagementVO;
import MemberManagement.util.SqlMapClientUtil;

public class MemberManagementServiceImpl implements MemberManagementService {
	
	private MemberManagementDao memDao;
	private SqlMapClient smc;
	
	public static MemberManagementService service;
	
	private MemberManagementServiceImpl() {
		memDao = MemberManagementDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static MemberManagementService getInstance() {
		if(service == null) {
			service = new MemberManagementServiceImpl();
		}
		return service;
	}

	@Override
	public List<MemberManagementVO> memberAllListPrint() {
		List<MemberManagementVO> memList = new ArrayList<>();

		try {
			memList = memDao.memberAllListPrint(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int memberInfoInsert(MemberManagementVO mv) {
		int cnt = 0;
		try {
			smc.startTransaction();
			cnt = memDao.memberInfoInsert(smc, mv);
			smc.commitTransaction();
		} catch (SQLException e) {
			try {
				smc.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int memberInfoUpdate(MemberManagementVO mv) {
		int cnt = 0;

		try {
			cnt = memDao.memberInfoUpdate(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int memberInfoDelete(MemberManagementVO mv) {
		int cnt = 0;

		try {
			cnt = memDao.memberInfoDelete(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberManagementVO getMemberInfo(String memId) {
		MemberManagementVO mv = null;
		
		try {
			mv = memDao.getMemberInfo(smc, memId);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return mv;
	}

	@Override
	public boolean checkMember(MemberManagementVO mv) {
		boolean chk = false;
		
		try {
			chk = memDao.checkMember(smc, mv);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

}
