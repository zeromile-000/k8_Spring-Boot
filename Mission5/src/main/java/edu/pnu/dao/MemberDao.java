package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import edu.pnu.JDBCConnect;
import edu.pnu.domain.MemberDTO;

@Repository
public class MemberDao extends JDBCConnect {

	public Map<String, Object> getAllMember() {
		
		Map<String, Object> map = new HashMap<String, Object>();

		List<MemberDTO> list = new Vector<MemberDTO>();
		String query = "select * from member";
		map.put("sqlstring", query);
		map.put("method", "get");

		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
//            MemberDTO dto = MemberDTO.builder()
//                  .id(rs.getInt("id"))
//                  .pass(rs.getString("pass"))
//                  .name(rs.getString("name"))
//                  .regidate(rs.getDate("regidate"))
//                  .build();
//            list.add(dto);

				list.add(MemberDTO.builder()
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build());
			}
			map.put("list", list);
			map.put("success",true);
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
			map.put("success", false);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public Map<String, Object> getMemberById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=?";
		map.put("sqlstring", query);
		map.put("method", "get");
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getDate("regidate"));
			}
			map.put("select", dto);
			map.put("success",true);

		} catch (Exception e) {
			System.out.println("검색 중 예외 발생");
			e.printStackTrace();
			map.put("success", false);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public Map<String, Object> addMember(MemberDTO memberDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		PreparedStatement psmt = null;
		String query = "INSERT INTO member(pass, name) VALUES(?, ?)";
		map.put("sqlstring", query);
		map.put("method", "post");
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberDto.getPass());
			psmt.setString(2, memberDto.getName());
			psmt.executeUpdate();
			
			map.put("insert", memberDto);
			map.put("success",true);
			

		}
		catch (Exception e) {
			System.out.println("데이터 입력중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				map.put("success", false);
			}
		}
		return map;
	}

	public Map<String, Object> updateMember(MemberDTO memberDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		PreparedStatement psmt = null;
		String query = "UPDATE member SET pass=?, name=?  WHERE id=?";
		map.put("sqlstring", query);
		map.put("method", "put");
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberDto.getPass());
			psmt.setString(2, memberDto.getName());
			psmt.setInt(3, memberDto.getId());
			psmt.executeUpdate();
			map.put("update", memberDto);
			map.put("success",true);
			

		} catch (Exception e) {
			System.out.println("수정중 예외 발생");
			e.printStackTrace();
			map.put("success", false);
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return map;
	}

	public Map<String, Object> removeMember(MemberDTO memberDto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		PreparedStatement psmt = null;
		String query = "DELETE FROM member WHERE id=?";
		map.put("sqlstring", query);
		map.put("method", "delete");
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, memberDto.getId());
			psmt.executeUpdate();
			map.put("delete", memberDto);
			map.put("success",true);
			
			
		} catch (Exception e) {
			System.out.println("삭제중 예외 발생");
			e.printStackTrace();
			map.put("success", false);
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
