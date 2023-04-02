package fr.wowjavafx.factory;

import fr.wowjavafx.objets.Armes;

import java.util.Random;

public class ArmeFactory {
    /**
     * Cree des armes, tout aléatoire : nom, degat, longueur, poids
     * @return une instance de Armes
     */
    public static Armes build(){
        Integer rand = new Random().nextInt(1,6);
        Armes armes;
        Integer degat = new Random().nextInt(10,21);
        Integer longueur = new Random().nextInt(40,81);
        Integer poids = new Random().nextInt(350,601);

        switch (rand){
            case 1:
                degat = new Random().nextInt(10,21);
                longueur = new Random().nextInt(40,81);
                poids = new Random().nextInt(350,601);
            armes = new Armes("Epée", degat, longueur, poids);
            break;
            case 2:
                degat = new Random().nextInt(10,21);
                longueur = new Random().nextInt(25,41);
                poids = new Random().nextInt(150,301);
                armes = new Armes("Gourdin", degat, longueur, poids);
                break;
            case 3:
                degat = new Random().nextInt(20,41);
                longueur = new Random().nextInt(30,51);
                poids = new Random().nextInt(250,401);
                armes = new Armes("Masse", degat, longueur, poids);
                break;
            case 4:
                degat = new Random().nextInt(20,41);
                longueur = new Random().nextInt(20,36);
                poids = new Random().nextInt(25,101);
                armes = new Armes("Dague", degat, longueur, poids);
                break;
            case 5:
                degat = new Random().nextInt(25,51);
                longueur = new Random().nextInt(30,61);
                poids = new Random().nextInt(300,501);
                armes = new Armes("Hache", degat, longueur, poids);
                break;
            default:
                degat = new Random().nextInt(10,21);
                longueur = new Random().nextInt(25,41);
                poids = new Random().nextInt(150,301);
                armes = new Armes("Gourdin", degat, longueur, poids);
        }
        return armes;
    }
}
