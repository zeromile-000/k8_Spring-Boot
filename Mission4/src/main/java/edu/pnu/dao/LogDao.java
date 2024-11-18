package edu.pnu.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import edu.pnu.JDBCConnect;

public class LogDao extends JDBCConnect {

	public void addLog(Map<String, Object> logmap) {
		PreparedStatement psmt = null;
		String query = "INSERT INTO dblog(method, sqlstring, success) VALUES(?, ?, ?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, (String)logmap.get("method"));
			psmt.setString(2, (String)logmap.get("sqlstring"));
			psmt.setBoolean(3, (Boolean)logmap.get("success"));
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
	}

}
