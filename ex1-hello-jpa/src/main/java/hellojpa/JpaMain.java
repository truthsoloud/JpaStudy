package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            //team엔티티를 저장하는데 옆 테이블에 가서 update할 수 밖에 없음. 어쩔 수 없이 쿼리가 하나 더 나가야하는 부분.
            //이 구조의 또 하나의 문제점: 실무에는 테이블이 굉장히 많으므로 운영이 힘들어진다.
            team.getMembers().add(member);

            em.persist(team);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
