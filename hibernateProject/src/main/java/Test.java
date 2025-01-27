
import jakarta.persistence.*;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        addInsert();

    }


    public static void addInsert(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (emf; em) {
            tx.begin();
            //code here
            //transient state
            //still not in the session
            //it is on the heap
            //changes won't affect directl in database
            //object is not conneced to any sessios or object is created by the closed session
            Customer
            customer.setName("Ana");
            customer.setBirthYear(2010);

            //moving to persistent state
            //1. using the hibernated session, save the entity object into the database table
            //2. using the hibernate session, load the entity object into the database table
            //merge je za update
            em.persist(customer);
            //try here to throw exception
            tx.commit();
            //try here to do exception
        } finally {
            //closing
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public static List<Customer> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.name = :name", Customer.class);
            query.setParameter("name", name);
            return query.getResultList();
        } finally {
            em.close();
            emf.close();

        }
    }


    public static void delete(Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (emf; em) {
            tx.begin();
            // Check if the entity is managed by the EntityManager, and if not, merge it before removal
            em.remove(em.contains(customer) ? customer : em.merge(customer));
        } finally {
            //closing
            if (tx.isActive()) {
                tx.rollback();
            }
        }


    }


}



