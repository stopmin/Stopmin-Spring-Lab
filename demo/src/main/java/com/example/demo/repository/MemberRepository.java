package com.example.demo.repository;

import com.example.demo.Domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

  Member save(Member member);

  Optional<Member> findById(Long id); // 없으면 null로 반환하는데 요즘은 optional로 묶어버림

  Optional<Member> findByName(String name);

  List<Member> findAll();
}
