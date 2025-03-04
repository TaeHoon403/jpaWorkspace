package com.kh.app0304jpa.board;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@SequenceGenerator(name = "abc" , sequenceName = "SEQ_BOARD" , allocationSize = 1)
@Data
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "abc")
    private Long no;
    private String title;
    private String content;
    private LocalDateTime enrollDate;
    private LocalDateTime modifyDate;
    private String delYn;

}
