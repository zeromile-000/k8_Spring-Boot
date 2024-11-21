package com.rubypaper;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest2 {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test // 테스트데이터를100 건입력
	public void dataPrepare2() {
		Random random = new Random();
		for(int i = 1; i <= 100; i++) {
			Long rand = random.nextLong(101);
			Board board = new Board();
			board.setTitle("테스트 제목" + i);
			board.setWriter("테스터");
			board.setContent("테스터 내용" + i);
			board.setCreateDate(new Date());
			board.setCnt(rand);
			boardRepo.save(board);
		}
	}
	
//	@Test // title에 “1” 이 포함되는 데이터 출력
	public void testFindByTitle2() {
		List<Board> boardList = boardRepo.findByTitleLike("%1%");
		System.out.println("검색 결과");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
		
//	@Test  // title에 “1” 이 포함되면서 cnt가 50보다 큰 데이터 출력
	public void testfindByTitleLikeAndCntAfter() {
		List<Board> boardList = boardRepo.findByTitleLikeAndCntAfter("%1%",50L);
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
//	@Test // Cnt가 10~50 사이인 데이터를 seq 오름차순으로 출력
	public void testfindByCntBetweenOrderBySeq() {
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeq(10L,50L);
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	// @Test // title에 “10”이 포함되거나 content에 “2”가 포함되는 데이터를 seq 내림차순으로 출력
	public void testfindByTitleLikeOrContentLikeOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleLikeOrContentLikeOrderBySeqDesc("%10%", "%2%");
		for(Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}
	
	
	
}
