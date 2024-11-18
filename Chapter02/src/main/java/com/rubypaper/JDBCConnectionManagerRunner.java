package com.rubypaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

public class JDBCConnectionManagerRunner implements ApplicationRunner {
	@Autowired
	 private JDBCConnectionManager connectionManager;
	 @Override
	 public void run(ApplicationArguments args) throws Exception {
	 System.out.println("커넥션매니저: "+ connectionManager.toString());

	 }
}
