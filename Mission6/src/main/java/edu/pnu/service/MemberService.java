package edu.pnu.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domaim.Logdomain;
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
		List<Member> list = memberRepo.findAll();
		Logdomain ld = new Logdomain();
		ld.setMethod("getAll");
		ld.setSqlstring("");
		ld.setSuccess(true);
		logRepo.save(ld);
		return list;
	}
	
	public Member getMember(Integer id) {
		memberRepo.findById(id).orElse(null);
		Logdomain ld = new Logdomain();
		ld.setMethod("get");
		ld.setSqlstring("");
		ld.setSuccess(true);
		logRepo.save(ld);
		return null;
	}
	
	public Member postMember(Member member) {
		Logdomain ld = new Logdomain();
		ld.setMethod("post");
		ld.setSqlstring("");
		ld.setSuccess(true);
		logRepo.save(ld);
		member.setPass("pass1");
		member.setName("김준영");
		member.setRegiDate(new Date());
		return memberRepo.save(member);
	}
	
	public Member putMember(Member member) {
		Logdomain ld = new Logdomain();
		ld.setMethod("put");
		ld.setSqlstring("");
		ld.setSuccess(true);
		logRepo.save(ld);
		Member member2 = memberRepo.findById(member.getId()).get();
		if(member.getName() != null) member2.setName(member.getName());
		
		return memberRepo.save(member2);
	}
	
	public Member deleteMember(Integer id) {
		Logdomain ld = new Logdomain();
		ld.setMethod("delete");
		ld.setSqlstring("");
		ld.setSuccess(true);
		logRepo.save(ld);
		Member member3 = memberRepo.findById(id).get();
		memberRepo.deleteById(id);
		return member3;
	}
	

}
