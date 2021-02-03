package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CLIENT")
public class Client {

    @Id
    private int id;

    @Column(name="NOM", length = 100, nullable = false)
    private String nom;

    @Column(name="PRENOM", length = 30, nullable = false)
    private String prenom;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prénom='" + prenom + '\'' +
                '}';
    }

    public Client(){
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts = new HashSet<>();

    public void getAllEmprunts(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-test-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Emprunt> query = em.createQuery("SELECT e FROM Emprunt e WHERE client.id = ?1", Emprunt.class);
        query.setParameter(1, id);

        System.out.println("Liste des emprunts pour un client: ");

        for (int i = 0; i<query.getResultList().size(); i++){
            Emprunt emprunt = query.getResultList().get(i);
            if (emprunt != null){
                emprunts.add(emprunt);
            }
        }
        System.out.println(emprunts);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
