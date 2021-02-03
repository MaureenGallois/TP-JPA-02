package domain;
import domain.Livre;
import domain.Emprunt;
import domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestBibliotheque {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés
        Emprunt emprunt = em.find( Emprunt.class, 2 );
        System.out.println( "Livres associés à l'emprunt 2: " );
        for( Livre associatedLivre : emprunt.getLivres()){
            System.out.println( associatedLivre );
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

        //Réalisez une requête qui permet d’extraire tous les emprunts d’un client donn
        Client client = new Client();
        client.getAllEmprunts(1);

    }
}
