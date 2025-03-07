package com.kh.app0307.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    // entity 로 생성된 테이블에 데이터를 넘겨주고 받아오는 작업을 수행해주는 클래스
    private final EntityManager manager;

    // 게시글 추가
    public void write(Board board) {
        manager.persist(board); // persist : insert 명령어
    }//write

}//class
