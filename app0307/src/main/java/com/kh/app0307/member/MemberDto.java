package com.kh.app0307.member;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    private Long no;
    private String id;
    private String pwd;
    private String nick;
    private LocalDateTime enrollDate;
    private LocalDateTime modifyDate;

}
