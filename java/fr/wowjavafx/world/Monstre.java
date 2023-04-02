package fr.wowjavafx.world;

/**
 * Permet de creer une instance de Monstre
 * nécessisant Des pdv, nom, force, endurance , coordonnées
 */
public class Monstre extends Combattant {

    public Monstre(String nom, Integer pointDeVie, Integer endurance) {
        super(nom, pointDeVie, endurance);
    }



}
