package com.MyLibrary.Lib.Service;

import com.MyLibrary.Lib.Exception.UserNotFoundException;
import com.MyLibrary.Lib.Model.Book;
import com.MyLibrary.Lib.Model.Member;
import com.MyLibrary.Lib.Service.BookService;
import com.MyLibrary.Lib.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private Book book;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }
    public void deleteMember(BigInteger id) {
        memberRepository.deleteMemberById(id);
    }
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    public Member findMemberByNickName(String nickName){
        return memberRepository.findMemberByNickName(nickName).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );
    }
}
