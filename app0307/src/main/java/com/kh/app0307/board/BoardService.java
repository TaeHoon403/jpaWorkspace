package com.kh.app0307.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    // 게시글 추가
    public void write(Board board) {
        repository.write(board);
    }//write

}//class
