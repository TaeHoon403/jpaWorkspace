package com.kh.app0307.member;

import com.kh.app0307.board.Board;
import com.kh.app0307.board.BoardDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor // 기본 생성자 생성 명시
public class MemberDto {

    private Long no;
    private String id;
    private String pwd;
    private String nick;
    private LocalDateTime enrollDate;
    private LocalDateTime modifyDate;
    private List<BoardDto> boardDtoList;
    
    // entity to dto 생성자
    public MemberDto(MemberEntity entity){
        this.no = entity.getNo();
        this.id = entity.getId();
        this.pwd = entity.getPwd();
        this.nick = entity.getNick();
        this.enrollDate = entity.getEnrollDate();
        this.modifyDate = entity.getModifyDate();
        // boardList 에서 값 꺼내서 dto 타입에 맞게 변환해서 넣어준다
//        this.boardDtoList = entity.getBoardList().stream().map(boardEntity->new BoardDto(boardEntity)).toList(); // 이 코드 간소화 하면 아래 코드
        this.boardDtoList = entity.getBoardList().stream().map(BoardDto::new).toList();

    }//MemberDto

}//clas
