import domain.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test-jpa");
        EntityManager em = emf.createEntityManager();
        Livre livre = em.find(Livre.class, 2);
        System.out.println(livre);
        em.close();
        emf.close();
    }
}
