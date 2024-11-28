package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.service.BoardService;

@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList(@ModelAttribute Member member, Model model) {
		if(member.getId() == null)
			return "redirect:login";
		
		List<Board> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute Member member,Board board, Model model) {
		if(member.getId() == null)
			return "redirect:login";
		
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute Member member) {
		if(member.getId() == null)
			return "redirect:login";
		
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute Member member,Board board) {
		if(member.getId() == null)
			return "redirect:login";
		
		boardService.insertBorad(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute Member member,Board board) {
		if(member.getId() == null)
			return "redirect:login";
		
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute Member member,Board board) {
		if(member.getId() == null)
			return "redirect:login";
		
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^");
	}
	
}
