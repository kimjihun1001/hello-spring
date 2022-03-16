package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    // Test를 import해주면 자동으로 얘를 실행해준다. main 메서드와 비슷하다!
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        // System.out.println 으로 확인해도 되겠지만, 일일이 이렇게 문자로 보는 것보다는 아래의 assertions 사용하기

        Assertions.assertEquals(member, result);    // 얘는 junit.jupiter api
        assertThat(member).isEqualTo(result);   // 얘는 assertj api

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member1);
    }
}
