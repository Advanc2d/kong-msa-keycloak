package com.msa.boardervice.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msa.boardervice.dto.BoardDto;
import com.msa.boardervice.entity.BoardEntity;
import com.msa.boardervice.model.Header;
import com.msa.boardervice.services.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
/* @CrossOrigin 어노테이션을 붙여주면 기본적으로 '모든 도메인, 모든 요청방식' 에 대해 허용 */
@RestController
public class BoardController {
    private final BoardService boardService;

    
    @GetMapping("/board/list")
    public Header<List<BoardDto>> boardList(
            @PageableDefault(sort = {"idx"}) Pageable pageable
    ) {
    	log.info("Hi getBoard");
        return boardService.getBoardList(pageable);
    }
    
    // 
//    @GetMapping("/board/list")
//    public List<BoardDto> boardList() { 
//    	log.info("boardList()");
//    	return boardService.getBoardList(); }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/board")
    public BoardEntity create(@RequestBody BoardDto boardDto) {
        return boardService.create(boardDto);
    }

    @PatchMapping("/board")
    public BoardEntity update(@RequestBody BoardDto boardDto) {
        return boardService.update(boardDto);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}
