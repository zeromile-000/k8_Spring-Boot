package com.rubypaper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import domain.BoardVO;


@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() throws Exception {
    	 BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
    	 assertEquals("테스터", board.getWriter());
 }
}
