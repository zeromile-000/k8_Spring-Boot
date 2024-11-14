package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberService {
	private List<MemberVO> list = new ArrayList<>();

	public MemberService() {
		for (int i = 1; i <= 10; i++) {
			list.add(MemberVO.builder().id(i).name("name" + i).pass("pass" + i).regidate(new Date()).build());
		}
		for (MemberVO m : list) {
			System.out.println(m.toString());
		}
	}
	
	// 검색 (Read - select)
    
    public List<MemberVO> getAllMember() {
        return list;
    }

    // 조회 (Read - select)
    
    public MemberVO getMemberById(Integer id) {
        for (MemberVO m : list) {
            if (m.getId() == id) 
            	return m;
        }
        return null;
    }

    // 입력 (Create - insert)
    
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
    
    public int updateMember(MemberVO memberVO) {
        MemberVO m = getMemberById(memberVO.getId());
        if (m == null) return 0;
        m.setName(memberVO.getName());
        m.setPass(memberVO.getPass());
        return 1;
    }

    // 삭제 (Delete - delete)
    public int removeMember(Integer id) {
        try {
            list.remove(getMemberById(id));
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
	

}
