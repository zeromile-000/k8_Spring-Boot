package edu.pnu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domaim.Member;
import edu.pnu.persistence.LogRepository;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private LogRepository logRepo;
	
	public List<Member> getMembers(){
		
//		logRepo.findAll();
		
		
		return memberRepo.findAll(); 
	}
	
	public Member getMember(Integer id) {
		memberRepo.findById(id).orElse(null);
		return null;
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
