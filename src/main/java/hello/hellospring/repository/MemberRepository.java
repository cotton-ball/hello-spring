package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null 을 반환하는 방법 중 하나
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트 반환
}
