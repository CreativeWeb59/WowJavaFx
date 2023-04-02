package fr.wowjavafx.actions;



import fr.wowjavafx.world.ICombattants;

import java.util.Random;

public class Combat {

    /**
     * Methode pour executer un combat
     * Prend 2 combattants en paramètre
     * Tire au sort qui joue en 1er
     * Tire au sort entre une attaque ou se nourrir
     */
    public static void combat(ICombattants hero, ICombattants monster) {
        while(hero.getPointDeVie() > 0 && monster.getPointDeVie() > 0) {
            int rand = new Random().nextInt(2);
            boolean turn = new Random().nextBoolean();
            // Si tour Héros
            if (turn) {
                attaque(hero,monster);
                gagnant(hero, monster);
                // Si tour Monstre
            } else {
                attaque(monster,hero);
                gagnant(hero, monster);
            }
        }
    }

    /**
     * Lance l'assaut d'un personnage
     * @param hero
     * @param monster
     */
    public static String tourCombat(ICombattants hero, ICombattants monster){
        String gagnant = "";
        // int rand = new Random().nextInt(2);
        boolean turn = new Random().nextBoolean();
        // Si tour Héros
        if (turn) {
            attaque(hero,monster);
            gagnant = gagnant(hero, monster);
            // Si tour Monstre
        } else {
            attaque(monster,hero);
            gagnant = gagnant(hero, monster);
        }
        return gagnant;
    }

    /**
     * Retourne un message pour savoir qui a gagné le combat
     * @param hero
     * @param monster
     */
    private static String gagnant(ICombattants hero, ICombattants monster) {
        String resultat = "Le combat continue";
        if (hero.getPointDeVie() > 0 && monster.getPointDeVie() <= 0) {
            System.out.println("Le vainqueur est " + hero.getNom());
            resultat = "Le vainqueur est " + hero.getNom();
        }
        else if (hero.getPointDeVie() <= 0 && monster.getPointDeVie() > 0){
            System.out.println("Le vainqueur est " + monster.getNom());
            resultat = "Le vainqueur est " + monster.getNom();
        }
        else {
            System.out.println("Le combat continue");
        }
        return resultat;
    }

    /**
     * Methode qui permet au combattant de jouer
     * choix entre : combattre et manger
     * rand dependant de l'endurance et des points de vie de l'attaquant
     * endurance > 30 => 1 chance sur 5 de manger
     * endurance < 30 => 1 chance sur 3 de manger
     * points de vie > 30 => 1 chance sur 5 de manger
     * points de vie < 30 => 1 chance sur 2 de manger
     * si 0 endurance ne peut pas attaquer => manger, si 0 nourriture => passe son tour
     */

    private static void attaque(ICombattants combattants1, ICombattants combattants2){

        // choix entre attaquer ou manger

        // creation d'un rand true = attaquer, false = manqger
        int action;
        int nbRandAction = new Random().nextInt(1, 6);

        if(combattants1.getSacoche().getNbNourriture() > 0){
            if((combattants1.getEndurance() > 30) && (combattants1.getPointDeVie() > 30) && (nbRandAction == 1)){
                Manger.manger(combattants1);
            } else if((combattants1.getEndurance() <= 30) && (combattants1.getPointDeVie() > 30) && combattants1.getEndurance() >= combattants1.perteEnduranceAttaquant() && (new Random().nextInt(1, 4)==1)) {
                Manger.manger(combattants1);
            } else  if((combattants1.getEndurance() > 30) && (combattants1.getPointDeVie() <= 30) && combattants1.getEndurance() >= combattants1.perteEnduranceAttaquant() && (new Random().nextInt(1, 3)==1)) {
                Manger.manger(combattants1);
            } else  if((combattants1.getEndurance() <= 30) && (combattants1.getPointDeVie() <= 30) && combattants1.getEndurance() >= combattants1.perteEnduranceAttaquant() && (new Random().nextInt(1, 3)==1)){
                Manger.manger(combattants1);
            } else if (combattants1.getEndurance() < combattants1.perteEnduranceAttaquant()) {
                Manger.manger(combattants1);
            } else {
                combattants1.attaquer(combattants2);
            }
        } else {
            System.out.println(combattants1.getNom() + " ne possède pas de nourriture");
            if(combattants1.getEndurance()<combattants1.perteEnduranceAttaquant()){
                System.out.println(combattants1.getNom() + " n'a pas assez d'endurance et de nourriture pour continuer le combat");
            } else {
                combattants1.attaquer(combattants2);
            }
        }


        // affichage resultat du combat

        System.out.println("Il reste " + combattants1.getPointDeVie() + " points de vie a "+ combattants1.getNom() + " et " + combattants1.getEndurance() + " d'endurance");
        System.out.println("Il reste " + combattants2.getPointDeVie() + " points de vie a "+ combattants2.getNom() + " et " + combattants2.getEndurance() + " d'endurance");
    }

}
