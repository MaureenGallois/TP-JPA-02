package domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="LIVRE")
public class Livre {
    @Id
    private int id;

    @ManyToMany(mappedBy = "livres")
    private Set<Emprunt> emprunts;

    @Column(name="TITRE", length = 100, nullable = false)
    private String titre;

    @Column(name="AUTEUR", length = 30, nullable = false)
    private String auteur;

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }

    public Livre(){
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
