package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board,Long>{
//	List<Board> findByTitle(String searchKeyword);
//	List<Board> findByContentContaining(String searchKeyword);
//	List<Board> findByTitleLikeOrContentLike(String title, String content);
//	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
//	List<Board> findByTitleLike(String title);
//	List<Board> findByTitleLikeAndCntAfter(String title, Long cnt);
//	List<Board> findByCntBetweenOrderBySeq(Long cnt1, Long cnt2);
//	List<Board> findByTitleLikeOrContentLikeOrderBySeqDesc(String title, String content);
//	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
//	Page<Board> findByTitleContaining(String keyword, Pageable paging);
//	Page<Board>findByTitleContaining(String searchKeyword, Pageable paging);
	
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
//	@Query("SELECT b FROM Board b WHERE b.title like %:searchKeyword% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b "
//			+ "WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(String searchKeyword);
	@Query(v)
	
	
	
	
	

}
