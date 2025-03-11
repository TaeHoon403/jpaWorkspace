package com.kh.app0307.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor // 기본 생성자 생성하도록 명시
public class BoardDto {

    private Long no;
    private String title;
    private String content;
    private LocalDateTime enrollDate;
    private Long writerNo;

    // entity to dto 생성자
    public BoardDto(Board entity){
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.enrollDate = entity.getEnrollDate();
        this.writerNo = entity.getMemberEntity().getNo();
    }//BoardDto

}//class
