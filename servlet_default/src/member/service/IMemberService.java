package member.service;

import java.util.List;

import member.vo.MemberVO;

public interface IMemberService {
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param mv 회원ID 
	 * @return 해당 회원ID가 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkMember(MemberVO mv);
	
	/**
	 * 주어진 회원ID에 해당하는 회원정보를 조회하는 메서드
	 * @param memId 검색할 회원ID
	 * @return 해당 회원ID에 해당하는 회원정보
	 */
	public MemberVO getMember(MemberVO mv);
	
	
}
