package com.kh.app0304jpa.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {

    private Long no;
    private String title;
    private String content;
    private LocalDateTime enrollDate;
    private LocalDateTime modifyDate;
    private String delYn;

}
