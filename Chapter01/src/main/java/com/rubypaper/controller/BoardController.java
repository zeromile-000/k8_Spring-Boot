package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController
public class BoardController {

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}

	@GetMapping("/hello") // /hello라는 쿼리스트링이 들어오면 아래를 메서드를 호출 후 결과를 반환
	public String hello(String name) { // http://localhost:8080/hello?name=김준영
		return "Hello:" + name;
	}

	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목...");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다........");
		board.setCteateDate(new Date());
		board.setCnt(0);
		return board;
	}

	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for (int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("제목" + i);
			board.setWriter("테스터");
			board.setContent(i + "번 내용 입니다");
			board.setCteateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}

}
