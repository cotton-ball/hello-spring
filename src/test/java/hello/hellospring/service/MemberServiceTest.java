package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository ;

    //Dependency Injection★
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach //테스트가 하나 끝나고 나면 데이터를 비워주는 역할
    public void afterEach(){
        memberRepository.clearStore();

    }


    @Test
    void 회원가입() { //한글로 해도 ok
        //given 주어지는 데이터
        Member member = new Member();
        member.setName("nayeon");

        //when 무엇을 검증하는지
        Long saveId = memberService.join(member);

        //then 검증부
        Member findMember = memberService.findOne( saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("nayeon");

        Member member2 = new Member();
        member2.setName("nayeon");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        /*
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        }

         */




    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
