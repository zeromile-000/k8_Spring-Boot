package com.rubypaper.board.persistence;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.rubypaper.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>,QuerydslPredicateExecutor<Board> {
	
	@Query("SELECT b FROM Board b")
	Page<Board> getBoardList(Pageable pageable);

}
