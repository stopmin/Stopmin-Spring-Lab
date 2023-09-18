package com.example.demo.repository;

import com.example.demo.Domain.Member;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryRepositoryTest {

  MemoryMemberRepository memberRepository = new MemoryMemberRepository();
  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);
    Member result = repository.findById(member.getId()).get();
    Assertions.assertEquals(member, result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member(); //shfit + f6
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();

    Assertions.assertEquals(member1, result);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    Assertions.assertEquals(2, result.size());

  }
}
