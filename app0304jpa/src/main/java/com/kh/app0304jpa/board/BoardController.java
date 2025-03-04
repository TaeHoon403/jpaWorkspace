package com.kh.app0304jpa.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    // 게시글 등록
    @PostMapping("insert")
    public void insert(@RequestBody BoardDto dto){
        service.insert(dto);
    }//insert

    // 게시글 상세 조회
    @GetMapping("detail/{no}")
    public BoardEntity getBoardByNo(@PathVariable Long no){
        return service.getBoardByNo(no);
    }//getBoardByNo

    // 게시글 목록 조회
    @GetMapping("list")
    public List<BoardEntity> getBoardAll (){
        return service.getBoardAll();
    }//getBoardAll

    // 게시글 수정
    @PostMapping("update")
    public void updateBoardByNo(Long no, String title, String content){
        service.updateBoardByNo(no,title,content);
    }//updateBoardByNo

    // 게시글 삭제
    @PostMapping("delete/{no}")
    public void deleteBoardByNo (@PathVariable Long no){
        service.deleteBoardByNo(no);
    }//deleteBoardByNo

}//class
