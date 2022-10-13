package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig { //의존관계 직접 등록을 위한 파일
    @Bean
    public MemberService memberService(){
        return new MemberService( memberRepository()); // 멤버 서비스는 멤버 레포지토리를 사용
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
