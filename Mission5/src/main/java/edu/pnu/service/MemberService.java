package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDao;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private LogDao logDao;

	// 검색 (Read - select)
    public List<MemberDTO> getAllMember() {
    	Map<String, Object> logmap = memberDao.getAllMember(); // logmap 객체의 map에 memberDao.getAllMember메소드 호출 및 반환결과 대입
        logDao.addLog(logmap); // logDao클래스의 map에 logmap의 결과를 대입 
        List<MemberDTO> list = (List<MemberDTO>) logmap.get("list"); // 
        return list;
    }

    // 조회 (Read - select)
    
    public MemberDTO getMemberById(Integer id) {
    	Map<String, Object> logmap = memberDao.getMemberById(id);
    	logDao.addLog(logmap);
    	MemberDTO dto = (MemberDTO) logmap.get("select");
    	return dto;
    }

    // 입력 (Create - insert)
    
    public MemberDTO addMember(MemberDTO MemberDto) {
    	Map<String, Object> logmap = memberDao.addMember(MemberDto);
    	logDao.addLog(logmap);
    	MemberDTO dto = (MemberDTO) logmap.get("insert");
    	return dto;
    }

    // 수정 (Update - update)
    
    public MemberDTO updateMember(MemberDTO MemberDto) {
    	Map<String, Object> logmap = memberDao.updateMember(MemberDto);
    	logDao.addLog(logmap);
    	MemberDTO dto = (MemberDTO) logmap.get("update");
    	return dto;
    }

    // 삭제 (Delete - delete)
    public MemberDTO removeMember(MemberDTO MemberDto) {
    	Map<String, Object> logmap = memberDao.removeMember(MemberDto);
    	logDao.addLog(logmap);
    	MemberDTO dto = (MemberDTO) logmap.get("delete");
    	return dto;
    }
    
	

}
