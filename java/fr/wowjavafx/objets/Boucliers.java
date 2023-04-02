package fr.wowjavafx.objets;

public class Boucliers implements Items{
    private String nom;
    private Integer defense;
    private Integer poids;

    public Boucliers(String nom, Integer defense, Integer poids) {
        this.nom = nom;
        this.defense = defense;
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getEncaissement() {
        return defense;
    }

    public void setEncaissement(Integer encaissement) {
        this.defense = encaissement;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Boucliers{" +
                "nom='" + nom + '\'' +
                ", defense=" + defense +
                ", poids=" + poids +
                '}';
    }
}
