package com.kh.app0307.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    // 회원가입
    public void join(MemberDto member) {
        repository.join(member);
    }//join

    // 회원 목록 조회
    public List<MemberEntity> getMemberAll() {
        return repository.getMemberAll();
    }//getMemberAll

    // 회원 상세 조회
    public MemberEntity getMemberByNo(Long no) {
        return repository.getMemberByNo(no);
    }//getMemberByNo

    // 회원 상세 조회 by ID
    public MemberEntity getMemberById(String id) {
        return repository.getMemberById(id);
    }//getMemberById

    // 회원 상세 조회 by Nick
    public MemberEntity getMemberByNick(String nick) {
        return repository.getMemberByNick(nick);
    }//getMemberByNick

    // 회원 삭제
    public void removeMember(Long no) {
        // 삭제할 회원 정보 가져오기
        MemberEntity member = getMemberByNo(no);
        // 회원 정보 삭제
        repository.removeMember(member);
    }//removeMember

    // 회원 정보 수정
    public void updateMember(MemberDto member) {
        MemberEntity entity = getMemberByNo(member.getNo());
        entity.setPwd(member.getPwd());
        entity.setNick(member.getNick());
    }//updateMember

}//class
