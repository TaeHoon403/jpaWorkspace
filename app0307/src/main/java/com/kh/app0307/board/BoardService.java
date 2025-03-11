package com.kh.app0307.board;

import com.kh.app0307.member.MemberEntity;
import com.kh.app0307.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;
    private final MemberRepository memberRepository;

    // 게시글 추가
    public void write(BoardDto boardDto) {

        // 게시글 entity 생성 및 제목,내용 추가
        Board boardEntity = new Board();
        boardEntity.setTitle(boardDto.getTitle());
        boardEntity.setContent(boardDto.getContent());

        // 게시글DTO 에서 회원번호로 회원정보 entity 조회 및 생성
        MemberEntity memberEntity = memberRepository.getMemberByNo(boardDto.getWriterNo());

        // 조회한 회원정보 entity 로 작성자 번호 추가
        boardEntity.setMemberEntity(memberEntity);

        repository.write(boardEntity);

    }//write

    // 게시글 상세 조회
    public Board getBoardByNo(Long no) {
        return  repository.getBoardByNo(no);
    }//getBoardByNo

    // 게시글 목록 조회
    public List<Board> getBoardAll() {
        return repository.getBoardAll();
    }//getBoardAll

    // 게시글 삭제
    public void deleteBoard(Long no) {
        Board board = getBoardByNo(no);
        repository.deleteBoard(board);
    }//deleteBoard

    // 게시글 수정
    public void updateBoard(BoardDto dto) {
        Board board = getBoardByNo(dto.getNo());
        board.setTitle(dto.getTitle());
        board.setTitle(dto.getContent());
    }//updateBoard

}//class
