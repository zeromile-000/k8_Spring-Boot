package com.rubypaper.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")

public class TestController {
	
	@Autowired
	private final BoardRepository boardRepo;
	
	@GetMapping("/board") // 전체 조회
	public List<Board> getBoards(){
		return boardRepo.findAll();
	}
	
	@GetMapping("/board/{seq}") // 한 건만 조회
	public Board getBoard(@PathVariable Long seq) {
		return boardRepo.findById(seq).orElse(null);
	}
	
	@PostMapping("/board") // 입력
	public Board postBoard(Board board) {
		board.setCreateDate(new Date());
		board.setCnt(0L);
		return boardRepo.save(board);
	}
	
	@PutMapping("/board") // 수정
	public Board putBoard(Board board) {
		Board board2 = boardRepo.findById(board.getSeq()).get();
		if(board.getTitle() != null) board2.setTitle(board.getTitle());
		return boardRepo.save(board2); 
	}
	
	@DeleteMapping("/board/{seq}") // 삭제
	public Board deleteBoard(@PathVariable Long seq) {
		Board b = boardRepo.findById(seq).get();
		boardRepo.deleteById(seq);
		return b;
	}

}

