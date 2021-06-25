package com.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.dto.MemberVO;

public class User implements UserDetails {
	
	private MemberVO member;

	//MemberVO가 필요없으면? 기본생성자를 지운다.
//	public User() {}
	
	//생성자를 만들 떄 MemberVO를 주어야 한다. --> 이 생성자만 있으면, MemberVO가 없으면 안된다.
	public User(MemberVO member) {
		this.member = member;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 유저의 권한을 리턴해주는 메서드
		
		//계정에 등록된 권한이 여러개이다 -> List형태이면
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(member.getAuthority()));
		return roles;
	}

	@Override
	public String getPassword() {
		//패스워드를 리턴
		return member.getPwd();
	}

	@Override
	public String getUsername() {
		//유저이름 리턴
		return member.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		//기간제 계정의 경우 기간만료 여부 : enabled = 4
		//Expired 기간만료
		//Exprired아니야! 그러니까 아닐 때 true
		
		return member.getEnabled()!=4;
	}

	@Override
	public boolean isAccountNonLocked() {
		//사용정지에 대한 계정 혹운 휴면 계정 enabled = 3
		//ex) 최초로그인 3개월전 이면 휴먼계정
		
		return member.getEnabled()!=3;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//안중정보 만료 여부 : enabled = 2
	
		return member.getEnabled()!=2;
	}

	@Override
	public boolean isEnabled() {
		//사용자가 내가 사용하겠다. 말겠다를 정한 것. 
		//탈퇴 혹은 삭제 : enabled = 0
		
		return member.getEnabled()==1;
	}
	
	//나중에 MemberVO를 꺼내기 위해서 따로 생성
	public MemberVO getMemberVO() {
		return this.member;
	}

}
