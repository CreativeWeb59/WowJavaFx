package fr.wowjavafx.actions;

import fr.wowjavafx.world.ICombattants;

public class Manger {
    /**
     * methode pour manger = utilise la nourriture de la sacoche
     * determine le besoin : points de vie ou endurance du combattant
     * recherche le meilleur besoin parmi la nourriture dans le sac
     * utilise la nourriture en ajoutant points de vie et endurance au combattant
     * supprime la nourriture du sac utilisée
     */
    public static void manger(ICombattants combattants){
        if(combattants.getPointDeVie() <= combattants.getEndurance()){
            combattants.utiliserNourriture(combattants.getSacoche().getTabNourriture(), combattants.getSacoche().getBestPdv());
        } else {
            combattants.utiliserNourriture(combattants.getSacoche().getTabNourriture(), combattants.getSacoche().getBestEndurance());
        }
    }
}
