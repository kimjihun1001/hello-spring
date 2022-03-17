package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

// 회원 리포지토리 메모리 구현체 테스트
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각 test가 끝날 때마다 실행
    // test는 각각 독립적으로 실행되며, 실행 순서가 보장되어 있지 않기 때문에 초기화하는 과정이 필요하다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    // Test를 import해주면 자동으로 얘를 실행해준다. main 메서드와 비슷하다!
    @Test
    public void save() {
        //given : 주어진 데이터
        Member member = new Member();
        member.setName("spring");

        //when : 테스트하고 싶은 기능
        repository.save(member);

        //then : 검사 결과
        Member result = repository.findById(member.getId()).get();
        // System.out.println 으로 확인해도 되겠지만, 일일이 이렇게 문자로 보는 것보다는 아래의 assertions 사용하기
        Assertions.assertEquals(result, member);    // 얘는 junit.jupiter api
        assertThat(result).isEqualTo(member);   // 얘는 assertj api
    }

    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        Member result = repository.findByName("spring2").get();

        //then
        assertThat(result).isEqualTo(member2);
    }
}
