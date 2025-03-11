package com.kh.app0307.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    // entity 로 생성된 테이블에 데이터를 넘겨주고 받아오는 작업을 수행해주는 클래스
    private final EntityManager manager;

    // 게시글 추가
    public void write(Board board) {
        manager.persist(board); // persist : insert 명령어
    }//write

    // 게시글 상세 조회
    public Board getBoardByNo(Long no) {
        return manager.find(Board.class,no);
    }//getBoardByNo

    // 게시글 목록 조회
    public List<Board> getBoardAll() {

        // 쿼리문 생성
        String jpql = "select b from Board b";
        // 쿼리문 수행
        return manager.createNamedQuery(jpql,Board.class).getResultList();

    }//getBoardAll

    // 게시글 삭제
    public void deleteBoard(Board board) {
        manager.remove(board);
    }//deleteBoard

}//class
