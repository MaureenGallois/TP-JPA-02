package domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {

    @Id
    private int id;

    @ManyToMany
    @JoinTable(name= "COMPO",
            joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID")
    )
    private Set<Livre>livres;

    @Column(name="DATE_DEBUT", length = 100, nullable = false)
    private LocalDateTime date_debut;

    @Column(name="DATE_FIN", length = 100, nullable = false)
    private LocalDateTime date_fin;

    @Column(name="DELAI", length = 10, nullable = false)
    private int delai;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    @Override
    public String toString() {
        return '\'' + "Emprunt{" +
                "id=" + id +
                ", date début= '" + date_debut + '\'' +
                ", date fin= '" + date_fin + '\'' +
                ", délai= '" + delai + '\'' +
                ", client= '"+ client + '\'' +
                ", liste de livre" + livres + '\'' +
                '}'+ '\'';
    }

    public Emprunt() {
    }

    public void setDateDebut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public void setDateFin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

}
