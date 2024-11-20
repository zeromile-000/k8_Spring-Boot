package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class App2 {

	private static void insertTest(EntityManagerFactory emf) {
		// EntityManager생성
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf1.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {
			// Transaction 시작
			tx.begin();

			Board board = new Board();
			board.setTitle("JPA 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글등록잘되네요");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			// 글등록
			em.persist(board);
			// Transaction commit
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Transaction rollback
			tx.rollback();
		} finally {
			em.close();
			emf1.close();
		}
	}

	private static void searchTest(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		try {
			Board searchBoard = em.find(Board.class, 2L);
			System.out.println("검색 결과: " + searchBoard);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private static void searchList(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();

		try {
			String jpql = "select b from Board b order by b.seq desc";
			List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			for (Board brd : boardList) {
				System.out.println("jpql 검색 결과" + brd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		// EntityManagerFactory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");

		insertTest(emf);
		searchTest(emf);
		searchList(emf);
		emf.close();
	}
}
