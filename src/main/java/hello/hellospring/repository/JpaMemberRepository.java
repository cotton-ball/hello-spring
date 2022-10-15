package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;
    //JPA 는 엔티티메니저로 동작을 한다-> 그래이들에 JPA 추가하면 스프링부트가 자동으로 엔티티 메니저 생성
    //생성된 것을 인젝션 해오는 거

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
        return result.stream().findAny();

    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList(); //인라인
    }
}
