package com.kh.app0307.member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    // 회원가입
    public void join(MemberDto member) {
        em.persist(member);
    }//join

    // 회원 목록 조회
    public List<MemberEntity> getMemberAll() {
        String jpql = "select m from MemberEntity m";
        // createQuery(실행할 쿼리문, 받아올 타입)
        return em.createQuery(jpql,MemberEntity.class).getResultList();
    }//getMemberAll

    // 회원 상세 조회
    public MemberEntity getMemberByNo(Long no) {
        return em.find(MemberEntity.class,no);
    }//getMemberByNo

    // 회원 상세 조회 by ID
    public MemberEntity getMemberById(String id) {
        String jpql = "select m from MemberEntity m where id = :userId";
        return em.createQuery(jpql,MemberEntity.class)
                .setParameter("userId",id)
                .getSingleResult();
    }//getMemberById

    // 회원 상세 조회 by Nick
    public MemberEntity getMemberByNick(String nick) {
        String jpql = "select m from MemberEntity m where nick = :userNick";
        return em.createQuery(jpql,MemberEntity.class)
                .setParameter("userNick",nick)
                .getSingleResult();
    }//getMemberByNick

    // 회원 삭제
    public void removeMember(MemberEntity member) {
        em.remove(member);
    }//removeMember
    
}//class

