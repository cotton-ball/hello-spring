package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    //저장을 해야 하기 때문에
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L; //시퀀스 : 0..1..2 키값을 생성해줌

    //스토어에 넣기 전에 멤버에 id 값을 세팅
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    //스토어에서 꺼내서 아이디로 찾음
    //optional 로 null이 올 때 감싸줌
    @Override
    public  Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    //람다 ★ 루프로 돌리면서 필터 -> 파라미터로 넘어온 이름이 같은지 비교해서 같으면 찾음 끝까지 없으면 numm 반환
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //스토어의 멤버 반환
    }

    public void clearStore(){
        store.clear();
    }
}
