package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
	// 검색 (Read - select)
    @GetMapping("/members")
    public List<MemberDTO> getAllMember() {
    	return memberService.getAllMember();
    }

    // 조회 (Read - select)
    @GetMapping("/member")
    public MemberDTO getMemberById(Integer id) {
    	return memberService.getMemberById(id);
    }

    // 입력 (Create - insert)
    @PostMapping("/member")
    public MemberDTO addMember(MemberDTO memberdto) {
    	return memberService.addMember(memberdto);
    }

    // 수정 (Update - update)
    @PutMapping("/member")
    public MemberDTO updateMember(MemberDTO memberdto) {
    	return memberService.updateMember(memberdto);
    }

    // 삭제 (Delete - delete)
    @DeleteMapping("/member")
    public MemberDTO removeMember(MemberDTO memberdto) {
    	return memberService.removeMember(memberdto);
    }

}
