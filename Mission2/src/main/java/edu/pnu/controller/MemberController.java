package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	MemberService ms = new MemberService();
	
	
	// 검색 (Read - select)
    @GetMapping("/members")
    public List<MemberVO> getAllMember() {
    	return ms.getAllMember();
    }

    // 조회 (Read - select)
    @GetMapping("/member")
    public MemberVO getMemberById(Integer id) {
    	return ms.getMemberById(id);
    }

    // 입력 (Create - insert)
    @PostMapping("/member")
    public MemberVO addMember(MemberVO memberVO) {
    	return ms.addMember(memberVO);
    }

    // 수정 (Update - update)
    @PutMapping("/member")
    public int updateMember(MemberVO memberVO) {
    	return ms.updateMember(memberVO);
    }

    // 삭제 (Delete - delete)
    @DeleteMapping("/member")
    public int removeMember(Integer id) {
    	return ms.removeMember(id);
    }

}
