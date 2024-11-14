package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import edu.pnu.JDBCConnect;
import edu.pnu.domain.MemberDTO;

public class MemberDao extends JDBCConnect {

	public List<MemberDTO> getAllMember() {

		List<MemberDTO> list = new Vector<MemberDTO>();
		String query = "select * from member";

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

				list.add(MemberDTO.builder().id(rs.getInt("id")).pass(rs.getString("pass")).name(rs.getString("name"))
						.regidate(rs.getDate("regidate")).build());
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
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
		return list;
	}

	public MemberDTO getMemberById(Integer id) {
		MemberDTO dto = new MemberDTO();
		String query = "select * from member where id=?";
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

		} catch (Exception e) {
			System.out.println("검색 중 예외 발생");
			e.printStackTrace();
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
		return dto;
	}

	public MemberDTO addMember(MemberDTO memberDto) {
		PreparedStatement psmt = null;
		String query = "INSERT INTO member(pass, name) VALUES(?, ?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberDto.getPass());
			psmt.setString(2, memberDto.getName());
			psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("데이터 입력중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDto;
	}

	public int updateMember(MemberDTO memberDto) {
		int result = 0;
		PreparedStatement psmt = null;
		String query = "UPDATE member SET pass=?, name=?  WHERE id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberDto.getPass());
			psmt.setString(2, memberDto.getName());
			psmt.setInt(3, memberDto.getId());
			result = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("수정중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int removeMember(Integer id) {
		int result = 0;
		PreparedStatement psmt = null;
		String query = "DELETE FROM member WHERE id=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			result = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("삭제중 예외 발생");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
