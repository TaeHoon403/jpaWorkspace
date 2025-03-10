package com.kh.app0307.board;

import com.kh.app0307.member.MemberEntity;
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

    // 작성자 회원 번호 (외래키)
    @ManyToOne// 이 컬럼은 join 을 위한 컬럼이다 명시 용 (1대1 , 1대다 , 다대1, 다대다 등 사용 가능)
    @JoinColumn(name = "writerNo" , nullable = false) // 외래키로 설정한 컬럼의 속성 정보
    private MemberEntity memberEntity; // 보드 가 다 , 멤버가 1 이므로 ManyToOne

}//class
