package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;


public class MemberService {
	
	private MemberDao memberDao = new MemberDao();

	// 검색 (Read - select) 
    public List<MemberDTO> getAllMember() {
        return memberDao.getAllMember();
    }

    // 조회 (Read - select)
    
    public MemberDTO getMemberById(Integer id) {
        return memberDao.getMemberById(id);
    }

    // 입력 (Create - insert)
    
    public MemberDTO addMember(MemberDTO MemberDto) {
        return memberDao.addMember(MemberDto);
    }

    // 수정 (Update - update)
    
    public int updateMember(MemberDTO MemberDto) {
    	return memberDao.updateMember(MemberDto);
    }

    // 삭제 (Delete - delete)
    public int removeMember(Integer id) {
    	return memberDao.removeMember(id);
    }
	

}
