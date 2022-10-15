package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//회원 서비스를 만들려면 일단 회원 리포지토리가 있어야 한다

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }
    //중복회원 확인 메서드
    private void validateDuplicateMember(Member member) { // 매서드로 바꿔준 것
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    //전체 회원 조회
    public List <Member> findMembers(){
        return memberRepository.findAll();
    }

    public  Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
