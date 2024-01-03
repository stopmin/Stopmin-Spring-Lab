package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // 왜 굳이 id를 반환하지?Member말고? command와 query를 분리해라.
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
