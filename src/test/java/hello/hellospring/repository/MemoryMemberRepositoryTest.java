package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    @AfterEach //테스트가 하나 끝나고 나면 데이터를 비워주는 역할
    public void afterEach(){
        repository.clearStore();

    }
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("nayeon");

        repository.save(member);
        Member result =  repository.findById(member.getId()).get();

        System.out.println("result = "+(result==member)); //1
        Assertions.assertEquals(member,result); //2
        //Assertions.assertEquals(member,null); //2.1
        assertThat(member).isEqualTo(result); //3 (옵션+엔터 -> 스태틱 임포트)
        //assertThat(member).isEqualTo(null); //3.1

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Nayeon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Munchi");
        repository.save(member2);

        Member result = repository.findByName("Nayeon").get();

        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Nayeon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Munchi");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}

