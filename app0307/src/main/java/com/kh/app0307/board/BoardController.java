package com.kh.app0307.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {


    private final BoardService service;

    // 게시글 추가
    @PostMapping("write")
    public void write(@RequestBody  Board board){
        service.write(board);
    }//write

}//class
