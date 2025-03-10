package com.kh.app0307.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    // 회원가입
    @PostMapping("join")
    public void join(@RequestBody MemberDto member){
        service.join(member);
    }//join

    // 회원 목록 조회
    @GetMapping("list")
    public List<MemberEntity> getMemberAll(){
        return service.getMemberAll();
    }//getMemberAll

    // 회원 상세 조회
    @GetMapping("{no}")
    public MemberEntity getMemberByNo(@PathVariable Long no){
        return service.getMemberByNo(no);
    }//getMemberByNo

    // 회원 상세 조회 by ID
    @GetMapping("search/id/{id}")
    public MemberEntity getMemberById(@PathVariable String id){
        return service.getMemberById(id);
    }//getMemberById

    // 회원 상세 조회 by Nick
    @GetMapping("search/nick/{nick}")
    public MemberEntity getMemberByNick(@PathVariable String nick){
        return service.getMemberByNick(nick);
    }//getMemberByNick

    // 회원 삭제
    @DeleteMapping("delete/{no}")
    public void removeMember(@PathVariable Long no){
        service.removeMember(no);
    }//removeMember

    // 회원 정보 수정
    @PutMapping("update")
    public void updateMember(@RequestBody MemberDto member){
        service.updateMember(member);
    }//updateMember

}//class
