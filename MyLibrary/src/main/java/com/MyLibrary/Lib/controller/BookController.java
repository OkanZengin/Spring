package com.MyLibrary.Lib.controller;
import com.MyLibrary.Lib.Service.MemberService;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.List;
@RestController
public class BookController {

    private final MemberService memberService;

    public BookController(MemberService memberService) {
        this.memberService = memberService;
    }


}
