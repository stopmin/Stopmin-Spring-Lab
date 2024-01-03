package jpa_basic.hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team); // **
            em.persist(member);

//            team.getMembers().add(member); // ** setTeam에 집어넣어준다
            team.addMember(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        // Closing EntityManagerFactory
        emf.close();
    }
}
