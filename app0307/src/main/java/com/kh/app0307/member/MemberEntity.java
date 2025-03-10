package com.kh.app0307.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBER") // 생성할 테이블명 지정
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class) // (메인 클래스에 @EnableJpaAuditing 추가해야 사용 가능)
@SequenceGenerator(name = "abc", sequenceName = "SEQ_MEMBER", allocationSize = 1) // allocationSize : 오라클에서 자바로 읽어올때 읽어오는 양?
public class MemberEntity {

    @Id
    @GeneratedValue(generator = "abc",strategy = GenerationType.SEQUENCE)
    private Long no;

    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String pwd;
    private String nick;
    
    @CreationTimestamp // 신규 생성 시 현재 시간 자동 등록
    private LocalDateTime enrollDate;
    
    @LastModifiedDate // 마지막 변경 시간 자동 등록 (클래스 @ 에 LastModifiedDate 추가해야 사용 가능)
    private LocalDateTime modifyDate;

    @PrePersist
    public void m01(){
        System.out.println("######################################## MemberEntity.m01 ########################################");
    }

}//class