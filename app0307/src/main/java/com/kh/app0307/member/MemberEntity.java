package com.kh.app0307.member;

import com.kh.app0307.board.Board;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MEMBER") // 생성할 테이블명 지정
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class) // (메인 클래스에 @EnableJpaAuditing 추가해야 사용 가능)
@SequenceGenerator(name = "abc", sequenceName = "SEQ_MEMBER", allocationSize = 1) // allocationSize : 오라클에서 자바로 읽어올때 읽어오는 양?
@NoArgsConstructor // 기본 생성자 생성하도록 명시
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

    @OneToMany(mappedBy = "memberEntity")
    private List<Board> boardList;

    @PrePersist
    public void m01(){
        System.out.println("######################################## MemberEntity.m01 ########################################");
    }

    // dto to entity 생성자
    public MemberEntity(MemberDto dto){
//        this.no = dto.getNo();    // 현재 자동으로 입력되도록 해둠
        this.id = dto.getId();
        this.pwd = dto.getPwd();
        this.nick = dto.getNick();
//        this.enrollDate = dto.getEnrollDate(); // 현재 자동으로 입력되도록 해둠
//        this.modifyDate = dto.getModifyDate(); // 현재 자동으로 입력되도록 해둠
        // boardList 는 자동으로 생성할 경우는 있지만 DTO 에서 받아와서 넣어줄 일은 없다
    }//MemberEntity

}//class