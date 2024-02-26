package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.Domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

  MemberService memberService;
  MemberRepository memberRepository;

  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);

  }


  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    Assertions.assertEquals(member.getName(), findMember.getName());
  }

  @Test
  public void 중복_회원_예외() {
    // given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    // when
    memberService.join(member1);
//    try {
//      memberService.join(member2);
//      fail();
//    } catch (IllegalStateException e) {
//      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }

    assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    // then
  }

  @Test
  void findOne() {
  }
}