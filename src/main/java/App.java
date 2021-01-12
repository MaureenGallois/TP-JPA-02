import domain.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Livre newLivre = new Livre();
        newLivre.setTitre("Ratatouille");
        newLivre.setAuteur("Auguste Gusteau");
        em.persist(newLivre);
        Livre livre = em.find(Livre.class, 6);
        System.out.println(livre);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
