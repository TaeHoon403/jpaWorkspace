package com.kh.app0304jpa.member;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity // 해당 클래스의 내용을 entity 로 관리한다 => db 에 테이블이 생긴다
@SequenceGenerator(name = "abc", sequenceName = "SEQ_MEMBER", allocationSize = 1) // 시퀀스 생성기 => 이 generator 호출하면 옆에 작성 된 내용의 시퀀스가 생성 됨
public class Member {

    // entity 를 만든때는 기본 생성자가 반드시 필요한다 => 지금은 spring 에서 기본 생성자를 만들어줘서 따로 작성하지 않는다

    @Id // entity 를 만들때는 반드시 기본키가 필요하다 => ID = 기본키
    @GeneratedValue(generator = "abc",strategy = GenerationType.SEQUENCE) // 시퀀스를 생성해서 no 에서 사용
    private Long no; // no 컬럼

    @Column(length = 100 , nullable = false, unique = true)
    private String id; // id 컬럼 => 컬럼 추가는 필드 추가와 동일
    private String pwd;
    private String nick;
    
    @Column(name="joinDate") // 해당 값이 컬럼이라는 표시 (안달아도 자동 처리 됨) , 해당 컬럼의 속성값을 줄 수 있다
    private LocalDateTime enrollDate;

    @Column(columnDefinition = "CHAR(1) DEFAULT 'N' CHECK(DEL_YN IN ('Y' , 'N'))")
    private String delYn;

}
