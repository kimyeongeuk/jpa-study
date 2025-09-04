package jpql;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.dialect.MySQLDialect;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);



            Member member = new Member();
            member.setUsername("회원1");

            member.setTeam(teamA);
            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            Member member3 = new Member();
            member3.setUsername("회원2");
            member3.setTeam(teamB);
            em.persist(member);
            em.persist(member2);
            em.persist(member3);

            em.flush();
            em.clear();

            int resultCount = em.createQuery("update Member m set m.age=20")
                    .executeUpdate();
            em.clear();
            Member findMember = em.find(Member.class, member.getId());

            System.out.println("findMember = " + findMember.getAge());


            System.out.println(resultCount);

            System.out.println("member.getAge = "+ member.getAge());
            System.out.println("member2.getAge = "+ member2.getAge());
            System.out.println("member3.getAge = "+ member3.getAge());


            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();

    }
}
