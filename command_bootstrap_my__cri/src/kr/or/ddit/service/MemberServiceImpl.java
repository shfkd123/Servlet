package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;

public class MemberServiceImpl implements MemberService {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private MemberDAO memDao;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memDao = memberDAO;
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {

		SqlSession session = sqlSessionFactory.openSession();

		try {
			MemberVO member = memDao.selectMemberById(session, id);
			if (member == null)
				throw new NotFoundIDException();
			if (!pwd.equals(member.getPwd()))
				throw new InvalidPasswordException();
		} finally {
			session.close();
		}

	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();

		try {

			MemberVO member = memDao.selectMemberById(session, id);
			return member;
		} finally {
			session.close();
		}
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memList = memDao.selectMemberList(session);
			return memList;

		} finally {
			session.close();

		}
	}
	
	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {			
			List<MemberVO> memList = memDao.selectMemberList(session,cri);
			return memList;
		} finally {
			session.close();
		}
	}

	@Override
	public int memberInfoInsert(MemberVO mv) throws SQLException {
		int cnt = 0;

		SqlSession session = sqlSessionFactory.openSession();

		cnt = memDao.memberInfoInsert(session, mv);

		session.close();

		return cnt;
	}

	@Override
	public int memberInfoUpdate(MemberVO mv) throws SQLException {
		int cnt = 0;

		SqlSession session = sqlSessionFactory.openSession();

		cnt = memDao.memberInfoUpdate(session, mv);

		session.close();

		return cnt;
	}

	@Override
	public int memberInfoDelete(MemberVO mv) throws SQLException {
		int cnt = 0;

		SqlSession session = sqlSessionFactory.openSession();

		cnt = memDao.memberInfoDelete(session, mv);

		session.close();

		return cnt;
	}

	@Override
	public boolean checkMember(MemberVO mv) throws SQLException {
		boolean chk = false;

		SqlSession session = sqlSessionFactory.openSession();

		chk = memDao.checkMember(session, mv);

		session.close();

		return chk;
	}



}
