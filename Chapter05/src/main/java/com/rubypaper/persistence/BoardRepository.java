package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board,Long>{
//	List<Board> findByTitle(String searchKeyword);
//	List<Board> findByContentContaining(String searchKeyword);
//	List<Board> findByTitleLikeOrContentLike(String title, String content);
//	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	List<Board> findByTitleLike(String title);
	List<Board> findByTitleLikeAndCntAfter(String title, Long cnt);
	List<Board> findByCntBetweenOrderBySeq(Long cnt1, Long cnt2);
	List<Board> findByTitleLikeOrContentLikeOrderBySeqDesc(String title, String content);

}
