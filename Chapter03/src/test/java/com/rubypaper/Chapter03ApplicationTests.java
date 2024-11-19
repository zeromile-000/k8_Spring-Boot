package com.rubypaper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Chapter03ApplicationTests {
	

	
	@DisplayName("최초 JUnit 테스트 메서드 실행") // 실행되는 메서드의 명칭  설정
	@Test
	void contextLoads() {
		System.out.println("contextLoads()");
	}
	@Test
	void test01() {
		System.out.println("test01()");
	}
	@Test
	void test02() {
		System.out.println("test02()");
	}

}
