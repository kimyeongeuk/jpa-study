package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {


//          List<Member> result =  em.createQuery("select m from Member as m",Member.class)
//                  .getResultList();

            
            Member findM1 = em.find(Member.class,101L);
            Member findM2 = em.find(Member.class,101L);
            System.out.println("findM.getId() = " + findM1.getId());
            System.out.println("findM.getName() = " + findM1.getName());
            System.out.println("findM.getId() = " + findM2.getId());
            System.out.println("findM.getName() = " + findM2.getName());
            System.out.println("findM1 == findM2 = " + (findM1 == findM2));

            tx.commit();

        }catch(Exception e) {
            tx.rollback();
        }finally{
            em.close();
        }

        emf.close();


    }

}
