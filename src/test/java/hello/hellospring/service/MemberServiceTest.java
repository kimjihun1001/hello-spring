package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @Test
    void 회원가입() throws Exception{
        //Given
        Member member = new Member();
        member.setName("Hoon");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memoryMemberRepository.findById(saveId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void 중복_회원_예외() {
        //Given
        Member member = new Member();
        member.setName("Hoon");

        Member member2 = new Member();
        member2.setName("Hoon");

        //When
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2)); //예외가 발생해야 한다.

        //Then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void findOne() {
    }
}