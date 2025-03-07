package com.kh.app0307.member;

import jakarta.persistence.*;

@Entity
@Table(name = "MEMBER") // 생성할 테이블명 지정
@SequenceGenerator(name = "abc", sequenceName = "SEQ_MEMBER", allocationSize = 1) // allocationSize : 오라클에서 자바로 읽어올때 읽어오는 양?
public class MemberEntity {

    @Id
    @GeneratedValue(generator = "abc",strategy = GenerationType.SEQUENCE)
    private Long no;

    @Column(length = 4000)
    private String id;
    @Column(length = 4000)
    private String pwd;

}//class