package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domaim.Member;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members") // 전체 조회
	public List<Member> getMembers(){
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}") // 한 건만 조회
	public Member getMember(@PathVariable Integer id) {
		return memberService.getMember(id);
	}
	
	@PostMapping("/member") // 데이터 입력
	public Member postMember(Member member) {
		return memberService.postMember(member);
	}
	
	@PutMapping("/member") // 데이터 수정
	public Member putMember(Member member) {
		return memberService.putMember(member);
	}
	
	@DeleteMapping("/member/{id}") // 데이터 삭제
	public Member deletemember(@PathVariable Integer id) {
		return memberService.deleteMember(id);
	}
	

}
