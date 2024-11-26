package com.rubypaper.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public List<Board> getBoardList(){ // 전체 조회
		return boardRepo.findAll();
	}
	
	@Override
	public Board getBoard(Board board) { // 1건만 조회
		return boardRepo.findById(board.getSeq()).get();
	}
	
	@Override
	public void insertBorad(Board board) { // 삽입
		boardRepo.save(board);
		
	}
	
	@Override
	public void updateBoard(Board board) { // 수정
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setWriter(board.getWriter());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
		
	}
	
	@Override
	public void deleteBoard(Board board) { // 삭제
		boardRepo.deleteById(board.getSeq());
		
	}
}
