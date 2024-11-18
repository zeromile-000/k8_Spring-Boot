package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCConnect {
	public Connection con;
	public PreparedStatement psmt;
//	public ResultSet rs;

	public JDBCConnect() {
		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB에 연결
			String url = "jdbc:mysql://localhost:3306/bootmission";
			String id = "musthave";
			String pwd = "Tiger12#$";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공 (기본 생성자)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			con.close();
			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
