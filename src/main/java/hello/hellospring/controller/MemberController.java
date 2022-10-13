package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class  MemberController {
    public final MemberService memberService; // 한 번만 등록을 해주면 됨

    @Autowired//스프링 컨테이너가 멤버 서비스를 가져다가 연결을 시켜준다
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

