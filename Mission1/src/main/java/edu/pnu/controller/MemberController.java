package edu.pnu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController
public class MemberController {

    private List<MemberVO> list = new ArrayList<>(); // MemberVO의 정보를 담을 list라는 이름의 ArrayList를 생성

    public MemberController() { // MemberController의 기본 생성자 정의
        for (int i = 1; i <= 10; i++) { // 1 ~ 10까지 10번 반복
            list.add(MemberVO.builder() // list 객체에 MemberVO 빌더 패턴을 추가
                .id(i)
                .name("name" + i)
                .pass("pass" + i)
                .regidate(new Date())
                .build()); 
        }
        for(MemberVO m : list) { // list 객체의 정보를 m에 반복해서 대입
        	System.out.println(m.toString()); // m의 toString 메서드를 호출
        }
    }

    // 검색 (Read - select)
    @GetMapping("/members") //  url에 "/members"라는 단어가 들어가면 get 방식으로 매핑 후 아래 메서드 실행  
    public List<MemberVO> getAllMember() {
        return list;
    }

    // 조회 (Read - select)
    @GetMapping("/member")
    public MemberVO getMemberById(Integer id) {
        for (MemberVO m : list) {
            if (m.getId() == id) 
            	return m;
        }
        return null;
    }

    // 입력 (Create - insert)
    @PostMapping("/member")
    public MemberVO addMember(MemberVO memberVO) {
        if (getMemberById(memberVO.getId()) != null) {
            System.out.println(memberVO.getId() + "가 이미 존재합니다.");
            return null;
        }
        memberVO.setRegidate(new Date());
        list.add(memberVO);
        return memberVO;
    }

    // 수정 (Update - update)
    @PutMapping("/member")
    public int updateMember(MemberVO memberVO) {
        MemberVO m = getMemberById(memberVO.getId());
        if (m == null) return 0;
        m.setName(memberVO.getName());
        m.setPass(memberVO.getPass());
        return 1;
    }

    // 삭제 (Delete - delete)
    @DeleteMapping("/member")
    public int removeMember(Integer id) {
        try {
            list.remove(getMemberById(id));
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
