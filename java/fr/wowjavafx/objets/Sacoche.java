package fr.wowjavafx.objets;

import java.util.Iterator;
import java.util.List;

public class Sacoche implements Iterable<Armes> {
    private List<Armes> tabArmes;
    private List<Boucliers> tabBoucliers;
    private List<Nourritures> tabNourritures;

    public Sacoche(List<Armes> tabArmes, List<Boucliers> tabBoucliers, List<Nourritures> tabNourriture) {
        this.tabArmes = tabArmes;
        this.tabBoucliers = tabBoucliers;
        this.tabNourritures = tabNourriture;
    }

    public List<Armes> getTabArmes() {
        return tabArmes;
    }

    public void addArme(List<Armes> tabArmes) {
        this.tabArmes = tabArmes;
    }

    public List<Boucliers> getTabBoucliers() {
        return tabBoucliers;
    }

    public void addBouclier(List<Boucliers> tabBoucliers) {
        this.tabBoucliers = tabBoucliers;
    }

    public List<Nourritures> getTabNourriture() {
        return tabNourritures;
    }

    public void addNourriture(List<Nourritures> tabNourriture) {
        this.tabNourritures = tabNourriture;
    }

    @Override
    public String toString() {
        return "Sacoche{" +
                "tabArmes=" + tabArmes +
                ", tabBoucliers=" + tabBoucliers +
                ", tabNourritures=" + tabNourritures +
                '}';
    }

    @Override
    public Iterator<Armes> iterator() {
        return tabArmes.iterator();
    }

    /**
     * retourne la meilleure arme de la sacoche
     * @param armes
     * @return
     */
    public Armes bestArmes(List armes){
        Iterator<Armes> iter = iterator();
        // arme par defaut
        // modifie les valeurs si on trouve mieux niveau degats
        Armes bestArme = new Armes("Gourdin", 10, 30, 200);

        int max = 0;
        int index = 0;
        // 1re etape je recupere la valeur la + elevee
        while(iter.hasNext()){
            Armes e = iter.next();
            if (e.getDegat()>max){
                max = e.getDegat();
                bestArme.setNom(e.getNom());
                bestArme.setDegat(e.getDegat());
                bestArme.setLongueur(e.getLongueur());
                bestArme.setPoids(e.getPoids());
            }
        }
        return bestArme;
    }

    /**
     * retourne le detail de l'arme equipee dans la sacoche
     * @param index
     * @return
     */
    public Armes armeEquipee(int index){
        return tabArmes.get(index);
    }

    /**
     * retourne le detail du bouclier equipe dans la sacoche
     * @param index
     * @return
     */
    public Boucliers bouclierEquipe(int index){
        return tabBoucliers.get(index);
    }

    /**
     * Retourne le nombre de nourriture de la liste nourriture
     */
    public Integer getNbNourriture(){
        return this.tabNourritures.size();
    }

    /**
     * Retourne l'id de la meilleure nourriture de la sacoche
     * donnant le plus de points de vie
     * @return
     */
    public Integer getBestPdv(){
        Iterator<Nourritures> iterator = this.tabNourritures.listIterator();
        Integer bestPdv = 0;
        Integer idBestPdv = 0;
        Integer index = 0;
        while (iterator.hasNext()){
            Nourritures l = iterator.next();
            if(l.getNbPointdevie() > bestPdv){
                bestPdv = l.getNbPointdevie();
                idBestPdv = index;
            }
            index++;
        }

        return idBestPdv;
    }

    /**
     * Retourne l'id de la meilleure nourriture de la sacoche
     * donnant le plus d'endurance
     */
    public Integer getBestEndurance(){
        Iterator<Nourritures> iterator = this.tabNourritures.listIterator();
        Integer bestEndurance = 0;
        Integer idBestEndurance = 0;
        Integer index = 0;
        while (iterator.hasNext()){
            Nourritures l = iterator.next();
            if(l.getNbEndurance() > bestEndurance){
                bestEndurance = l.getNbEndurance();
                idBestEndurance = index;
            }
            index++;
        }
        return idBestEndurance;
    }
}
