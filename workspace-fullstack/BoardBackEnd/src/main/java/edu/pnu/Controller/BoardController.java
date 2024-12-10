package edu.pnu.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.Service.BoardService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardController {
    
    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<?> getBoard() {
        log.info("getBoard: All");
        return ResponseEntity.ok(boardService.getBoards()); 
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Long id) {
        log.info("getBoard: " + id);
        return ResponseEntity.ok(boardService.getBoard(id)); 
    }
}
