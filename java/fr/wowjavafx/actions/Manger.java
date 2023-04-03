package fr.wowjavafx.actions;

import fr.wowjavafx.world.ICombattants;

import java.util.ArrayList;
import java.util.List;

public class Manger {
    /**
     * methode pour manger = utilise la nourriture de la sacoche
     * determine le besoin : points de vie ou endurance du combattant
     * recherche le meilleur besoin parmi la nourriture dans le sac
     * utilise la nourriture en ajoutant points de vie et endurance au combattant
     * supprime la nourriture du sac utilisée
     */
    public static List<String> manger(ICombattants combattants){
        List<String> messageRetour = new ArrayList<>();
        if(combattants.getPointDeVie() <= combattants.getEndurance()){
            messageRetour.addAll(combattants.utiliserNourriture(combattants.getSacoche().getTabNourriture(), combattants.getSacoche().getBestPdv()));
        } else {
            messageRetour.addAll(combattants.utiliserNourriture(combattants.getSacoche().getTabNourriture(), combattants.getSacoche().getBestEndurance()));
        }
        return messageRetour;
    }
}
