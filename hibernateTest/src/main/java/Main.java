import entity.Customer;
import entity.Order;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer();

        customer.setName("Test4");
        customer.setBirthYear(2000);

       // saveCostumer(customer);
        List<Customer> customers = findStudentByName("Test4");
        for (Customer customer1 : customers) {
            System.out.println(customer1.getName());
        }
//        System.out.println(".................");
//        delete();
//        customers = findStudentByName("Test4");
//        for (Customer customer1 : customers) {
//            System.out.println(customer1.getName());
//        }
    }


    public static List<Customer> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.name = :name", Customer.class);
            query.setParameter("name", name);
//            List<Customer> customers = query.getResultList();
//            for (Customer customer : customers) {
//                customer.setBirthYear(customer.getBirthYear() + 1900);
//            }
//            return customers;
            return query.getResultList();
        } finally {
            em.close();
            emf.close();

        }
    }

    public static void saveCostumer(Customer customer) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        try {
            tx.begin();
            em.persist(customer);
            //nije ga sacuvao
            //if(true) throw new NullPointerException();

            tx.commit();
            //sacuvao ga je
            //throw new NullPointerException();
        } catch (Exception e) {
            System.out.println(tx.isActive());
            System.out.println(e.getMessage());
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
            emf.close();
        }
    }

    public static void delete() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try (emf; em) {
            tx.begin();

            Customer test3 = findStudentByName("Test3").getFirst();
            em.remove(test3);
            tx.commit();
        } finally {
            //closing
            if (tx.isActive()) {
                tx.rollback();
            }
        }


    }

}

