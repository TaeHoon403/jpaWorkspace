package com.kh.app0307.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {


    private final BoardService service;

    // 게시글 추가
    @PostMapping
    public void write(@RequestBody BoardDto boardDto){
        service.write(boardDto);
    }//write

    // 게시글 상세 조회
    @GetMapping("{no}")
    public Board getBoardByNo (@PathVariable Long  no){
        return service.getBoardByNo(no);
    }//getBoardByNo

    // 게시글 목록 조회
    @GetMapping("list")
    public List<Board> getBoardAll (){
        return service.getBoardAll();
    }//getBoardAll

    // 게시글 삭제
    @DeleteMapping("{no}")
    public void deleteBoard(@PathVariable Long no){
        service.deleteBoard(no);
    }//deleteBoard

    // 게시글 수정
    @PutMapping
    public void updateBoard(@RequestBody BoardDto dto){
        service.updateBoard(dto);
    }//updateBoard

}//class
