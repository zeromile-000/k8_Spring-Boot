package com.rubypaper.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.BoardVO;

@RestController
public class BoardController {

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}

	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();

		board.setWriter("테스터");

		return board;
	}
}
