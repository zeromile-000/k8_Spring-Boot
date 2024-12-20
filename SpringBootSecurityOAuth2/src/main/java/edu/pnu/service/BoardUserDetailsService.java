package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class BoardUserDetailsService implements UserDetailsService { // 시큐리티가 이해할 수 있게 우리가 사용하는 데이터베이스의 데이터로 변환
	
	@Autowired
	private MemberRepository memberRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// 내가 작성한 객체 정보를 작성
		// memRepo에서 사용자 정보를 검색해서
		Member member = memberRepo.findById(username)
				.orElseThrow(()->new UsernameNotFoundException("Not Found"));
		System.out.println(member); // 검색된 사용자 정보를 console에 출력해서 확인
		
		// UserDetails 타입의 객체를 생성해서 리턴 (o.s.s.core.userdetails.User) // 시큐리티가 정의한 데이터 타입(데이터 변환)
		// 여기에서 리턴된 User 객체와 로그인 요청 정보를 비교한다.
		
		// 시큐리티가 이해할 수 있게 데이터를 변환 
		return new User(member.getUsername(), member.getPassword(),  AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}

}
