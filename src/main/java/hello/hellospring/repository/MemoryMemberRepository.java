package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// 회원 리포지토리 구현체
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  // 0,1,2 이렇게 키 값을 생성해주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // TODO : 람다식 공부하기
        // TODO : 이건 왜 Optional.ofNullable로 감싸지 않아도 되는 걸까?
        return store.values().stream()  // store를 순회하면서
                .filter(member -> member.getName().equals(name))    // 이 조건에 해당하는 애 찾음
                .findAny(); // 그 중에 아무거나 반환 ?
    }

    @Override
    public List<Member> findAll() {
        // 실무에서는 List를 많이 사용한다. 루프 돌리기도 용이하고 등등
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
