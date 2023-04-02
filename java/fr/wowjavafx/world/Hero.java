package fr.wowjavafx.world;

/**
 * Permet de créer une instance de Personnage
 * nécessitant Des pdv, nom, force, endurance , coordonnées
 */
public class Hero extends Combattant {
        public Hero(String nom, Integer pointDeVie, Integer endurance) {
        super(nom, pointDeVie, endurance);
    }


}
