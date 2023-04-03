package fr.wowjavafx.world;

import fr.wowjavafx.factory.SacocheFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Equipe implements Iterable<ICombattants> {
    private final List<ICombattants> tab;
    public Equipe(){
        this.tab = new ArrayList<>();
    }

    // Permet d’ajouter un combattant à une équipe
    public void addFighter(ICombattants pCombattants ){
        tab.add(pCombattants);
    }

    /**
     *   permet de donner une image a combattant
     */

    public String getNomImage (int index){
        // String nomImage = new String[tab.size()];
        String nomImage = "";
        int i = 0;
        for (ICombattants e: tab) {
            if (i == index){
                nomImage = e.getNom();
            }
            i ++;
        }
        return nomImage;
    }
    /**
     * Permet d’ajouter une sacoche à un combattant en parcourant l’équipe
     * elle est rempli d'armes, boucliers et nourriture par la SacocheFactory
     */
    public void addSacoche(){
        for (ICombattants e: tab) {
            e.setSacoche(SacocheFactory.build(e));
        }
    }
    public void afficheCombattant(){

        for (ICombattants e: tab) {
            System.out.println(e.getSacoche());
        }
    }

    /**
     * Permet d’equiper une arme à un combattant en parcourant l’équipe
     * recupere une arme aleatoire dans le slot Armes de la sacoche
     */
    public void equipeArme(){
        for (ICombattants e: tab) {
            e.setArmeEquipee(new Random().nextInt(0,e.getSacoche().getTabArmes().size()));
        }
    }

    /**
     * Permet d’equiper un bouclier à un combattant en parcourant l’équipe
     * recupere un bouclier aleatoire dans le slot Bouclier de la sacoche
     */
    public void equipeBouclier(){
        for (ICombattants e: tab) {
            e.setBouclierEquipe(new Random().nextInt(0,e.getSacoche().getTabBoucliers().size()));
        }
    }

    /**
     * Permet de recuperer le 1er combatant de l'équipe , celui à l'index 0
     * @return
     */
    public ICombattants chooseFighter(){
        if (tab.size() == 0){
            throw new RuntimeException("L'équipe est vide !");
        }else{
            int rand = new Random().nextInt(tab.size());
            return tab.get(rand); 
        }
    }

    /**
     * retourne la liste des l'équipe
     * @param index
     * @return
     */
    public ICombattants get(int index){
        return tab.get(index);
    }

    /**
     * retourne la taille de l'équipe
     * @return
     */
    public int size(){
        return tab.size();
    }

    /**
     * retourne un tableau iterateur de l'équipe
     * afin de pouvoir boucler dessus
     * @return
     */
    @Override
    public Iterator<ICombattants> iterator() {
        return tab.iterator();
    }

    /**
     * Utilise un iterateur pour parcourir la liste de personnages/monstres et savoir s’ils sont morts
     * @return renvoie true si le combattant est en vie, false si mort
     */
    public String[] isDead(){
        // boolean resultat = true;
        String resultat[] = new String[2];
        resultat[0] = "true";
        Iterator<ICombattants> iter = iterator();
        while(iter.hasNext()){
            ICombattants e = iter.next();
            if(e.getPointDeVie() > 0) {
                resultat[0] = "false" ;
            } else {
                iter.remove();
                System.out.println(e.getNom()+" est mort !\n");
                resultat[1] = e.getNom() + " est mort !\n";
            }
        }
        return resultat;
    }

    @Override
    public String toString() {
        return "Equipe{" + "tab=" + tab +'}';
    }
}
