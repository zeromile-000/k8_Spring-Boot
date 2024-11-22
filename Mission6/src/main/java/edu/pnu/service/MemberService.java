package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domaim.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	public List<Member> getMembers(){
		return memberRepo.findAll();
	}
	
	public Member getMember(Integer id) {
		return memberRepo.findById(id).orElse(null);
	}
	
	public Member postMember(Member member) {
		member.setPass("pass1");
		member.setName("김준영");
		member.setRegiDate(new Date());
		return memberRepo.save(member);
	}
	
	public Member putMember(Member member) {
		Member member2 = memberRepo.findById(member.getId()).get();
		if(member.getName() != null) member2.setName(member.getName());
		return memberRepo.save(member2);
	}
	public Member deleteMember(Integer id) {
		Member member3 = memberRepo.findById(id).get();
		memberRepo.deleteById(id);
		return member3;
	}
	

}
