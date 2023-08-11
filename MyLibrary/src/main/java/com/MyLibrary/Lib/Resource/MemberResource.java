package com.MyLibrary.Lib.Resource;

import com.MyLibrary.Lib.Model.Member;
import com.MyLibrary.Lib.Service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberResource {
    private final MemberService memberService;
    private PasswordEncoder passwordEncoder;


    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.findAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member newMember = memberService.addMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        passwordEncoder.encode(member.getPassword());
        Member updateMember = memberService.updateMember(member);
        return new ResponseEntity<>(updateMember, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") BigInteger id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getMemberBy/{nickName}")
    public ResponseEntity<Member> findMemberByNickName(@PathVariable("nickName") String nickName){
        memberService.findMemberByNickName(nickName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}