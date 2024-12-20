////package com.rubypaper;
////
////import java.util.List;
////
////import org.junit.jupiter.api.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////import org.springframework.data.domain.Sort;
////
////import com.rubypaper.domain.Board;
////import com.rubypaper.persistence.BoardRepository;
////
////@SpringBootTest
////public class QueryMethodTest {
////
////	@Autowired
////	private BoardRepository boardRepo;
////
//////	@BeforeEach
//////	public void dataPrepare() {
//////		for(int i = 1; i <=200; i++) {
//////			Board board = new Board();
//////			board.setTitle("테스트 제목" + i);
//////			board.setWriter("테스터");
//////			board.setContent("테스터 내용" + i);
//////			board.setCreateDate(new Date());
//////			board.setCnt(0L);
//////			boardRepo.save(board);
//////		}
//////	}
//////	@Test
////	public void testFindByTitle() {
////		List<Board> boardList = boardRepo.findByTitle("테스트 제목10");
////		System.out.println("검색 결과");
////		for (Board board : boardList) {
////			System.out.println("--->" + board.toString());
////		}
////	}
////
//////	@Test
////	public void testByContentContaining() {
////		List<Board> boardList = boardRepo.findByContentContaining("17");
////		System.out.println("검색 결과");
////		for (Board board : boardList) {
////			System.out.println("--->" + board.toString());
////		}
////	}
////
//////	@Test
////	public void testFindByTitleLikeOrContentLike() {
////		List<Board> boardList = boardRepo.findByTitleLikeOrContentLike("%17%", "%50%");
////		System.out.println("검색 결과");
////		for (Board board : boardList) {
////			System.out.println("--->" + board.toString());
////		}
////	}
////
//////	@Test
////	public void testFindByTitleContainingOrderBySeqDesc() {
////		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
////		System.out.println("내림차순 정렬 검색 결과");
////		for (Board board : boardList) {
////			System.out.println("--->" + board.toString());
////		}
////	}
//
////	@Test
////	public void testFindByTitleContaining() {
////		Pageable paging = PageRequest.of(0, 5);
////		List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
////		System.out.println("검색 결과");
////		for (Board board : boardList) {
////			System.out.println("--->" + boardList.toString());
////		}
//
////	@Test
////	 public void testFindByTitleContaining() {
////	 Pageable paging = PageRequest.of(1, 5, Sort.Direction.DESC, "seq");
////	 List<Board> boardList = boardRepo.findByTitleContaining("제목", paging); 
////	 System.out.println("검색결과");
////	 for (Board board : boardList) {
////			System.out.println("--->" + board.toString());
////		}
////	}
////	@Test
////	public void testFindByTitleContaining() {
////		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
////		Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);
////
////		// pageInfo정보출력
////		System.out.println("검색결과");
////		for (Board board : pageInfo) {
////			System.out.println("--->" + board.toString());
////		}
////	}
////	
//
//}
