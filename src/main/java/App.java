import domain.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //ajout d'un livre
        Livre newLivre = new Livre();
        newLivre.setTitre("Ratatouille");
        newLivre.setAuteur("Auguste Gusteau");
        em.persist(newLivre);

        //modification d'un livre
        Livre livre = em.find(Livre.class, 5);
        if(livre != null){
            livre.setTitre("Du plaisir dans la cuisine");
        }

        //recherche d'un livre par son id
        Livre findLivre = em.find(Livre.class, 5);
        System.out.println(findLivre);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
