package com.kh.app0304jpa.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    // 게시글 등록
    public void insert(BoardDto dto) {

        // 전달받은 DTO 객체를 Entity 객체로 변환
        BoardEntity entity = dtoToEntity(dto);

        // 전달받은 데이터 저장
        repository.save(entity);

    }//insert

    // 게시글 상세 조회
    public BoardEntity getBoardByNo(Long no){
        return repository.findById(no).orElse(null);
    }//getBoardByNo

    // 게시글 목록 조회
    public List<BoardEntity> getBoardAll(){
        return repository.findAll();
    }//getBoardAll

    // 게시글 수정
    public void updateBoardByNo(Long no, String title, String content){

        // 수정할 기존 entity 가져오기
        BoardEntity dbEntity = getBoardByNo(no);
        
        // 데이터 수정
        dbEntity.setTitle(title);
        dbEntity.setContent(content);

    }//updateBoardByNo

    // 게시글 삭제
    public void deleteBoardByNo(Long no){
        repository.deleteById(no);
    }//deleteBoardByNo

    // 전달받은 DTO 를 Entity 객체로 변환
    private BoardEntity dtoToEntity(BoardDto dto){
        BoardEntity entity = new BoardEntity();
        entity.setNo(dto.getNo());
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setEnrollDate(dto.getEnrollDate());
        entity.setModifyDate(dto.getModifyDate());
        return entity;
    }//dtoToEntity

    // 전달받은 Entity 를 DTO 객체로 변환
    private BoardDto entityToDto(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.setNo(entity.getNo());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setEnrollDate(entity.getEnrollDate());
        dto.setModifyDate(entity.getModifyDate());
        return dto;
    }//dtoToEntity

}//class
