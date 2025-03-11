package com.kh.app0307.board;

import com.kh.app0307.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "primaryKey", sequenceName = "SEQ_BOARD" , allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 생성하도록 명시
public class Board {

    @Id
    @GeneratedValue(generator = "primaryKey" , strategy = GenerationType.SEQUENCE)
    private Long no;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    @CreationTimestamp // 신규 생성 시 현재 시간 자동 등록
    private LocalDateTime enrollDate;

    // 작성자 회원 번호 (외래키)
    @ManyToOne// 이 컬럼은 join 을 위한 컬럼이다 명시 용 (1대1 , 1대다 , 다대1, 다대다 등 사용 가능)
    @JoinColumn(name = "writerNo" , nullable = false) // 외래키로 설정한 컬럼의 속성 정보
    private MemberEntity memberEntity; // 보드 가 다 , 멤버가 1 이므로 ManyToOne

    // dto to entity 생성자
    public Board(BoardDto dto){
//        this.no = dto.getNo();    // 현재 자동으로 입력되도록 해둠
        this.title = dto.getTitle();
        this.content = dto.getContent();
//        this.enrollDate = dto.getEnrollDate(); // 현재 자동으로 입력되도록 해둠
        // writerNo 생성자에서 넣어 줄 값이 없다
    }//Board

}//class
