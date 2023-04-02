package fr.wowjavafx.objets;

public class Nourritures implements Items{
    private String nom;
    private Integer nbPointdevie;
    private Integer nbEndurance;
    private Integer poids;

    public Nourritures(String nom, Integer nbPointdevie, Integer nbEndurance, Integer poids) {
        this.nom = nom;
        this.nbPointdevie = nbPointdevie;
        this.nbEndurance = nbEndurance;
        this.poids = poids;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbPointdevie() {
        return nbPointdevie;
    }

    public void setNbPointdevie(Integer nbPointdevie) {
        this.nbPointdevie = nbPointdevie;
    }

    public Integer getNbEndurance() {
        return nbEndurance;
    }

    public void setNbEndurance(Integer nbEndurance) {
        this.nbEndurance = nbEndurance;
    }

    @Override
    public Integer getPoids() {
        return poids;
    }

    @Override
    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Nourritures{" +
                "nom='" + nom + '\'' +
                ", nbPointdevie=" + nbPointdevie +
                ", nbEndurance=" + nbEndurance +
                ", poids=" + poids +
                '}';
    }
}
