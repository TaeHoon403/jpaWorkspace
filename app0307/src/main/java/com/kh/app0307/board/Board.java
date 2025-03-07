package com.kh.app0307.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "primaryKey", sequenceName = "SEQ_BOARD" , allocationSize = 1)
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(generator = "primaryKey" , strategy = GenerationType.SEQUENCE)
    private Long no;
    private String title;
    private String content;
    private LocalDateTime enrollDate;

}//class
