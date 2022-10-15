package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig { //의존관계 직접 등록을 위한 파일

    private final MemberRepository memberRepository;


    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

        private DataSource dataSource;

        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }

 */


    @Bean
    public MemberService memberService(){

        return new MemberService( memberRepository); // 멤버 서비스는 멤버 레포지토리를 사용
    }
  //  @Bean
    //public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);}

}
