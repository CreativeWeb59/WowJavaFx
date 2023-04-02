package fr.wowjavafx.factory;

import fr.wowjavafx.objets.Armes;
import fr.wowjavafx.objets.Boucliers;
import fr.wowjavafx.objets.Nourritures;
import fr.wowjavafx.objets.Sacoche;
import fr.wowjavafx.world.ICombattants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SacocheFactory {
    /**
     * Crée une sacoche avec 3 listes : armes, boucliers et nourritures
     * @param combattantsS
     * @return
     */
    public static Sacoche build(ICombattants combattantsS){
        Sacoche sacoche;
        List<Armes> listArmes = new ArrayList<>(buildArmes());
        List<Boucliers> listBoucliers = new ArrayList<>(buildBouclier());
        List<Nourritures> listNourritures = new ArrayList<>(buildNourriture());
        sacoche = new Sacoche(listArmes, listBoucliers, listNourritures);
        return sacoche;
    }

    /**
     * Crée une liste des armes contenues dans la sacoche
     * le nombre d'items est aléatoire
     * @return
     */
    public static List<Armes> buildArmes(){
        Integer nbArmes = new Random().nextInt(1,5);
        List<Armes> listArmes = new ArrayList<>();
        for (int i = 0; i <= nbArmes ; i++) {
            listArmes.add(ArmeFactory.build());
        }
        return listArmes;
    }
    /**
     * Crée une liste de boucliers contenus dans la sacoche
     * le nombre d'items est aléatoire
     * le bouclier équipé n'étant pas obligatoire, un bouclier "aucun" est crée automtiquement pour éviter les erreurs et simplifier les tests
     * si "aucun" est équipé, alors => le combattant n'a pas de bouclier
     * @return
     */
    public static List<Boucliers> buildBouclier(){
        Integer nbBoucliers = new Random().nextInt(1,5);
        List<Boucliers> listBoucliers = new ArrayList<>();
        Boucliers boucliers;
        // creation d'un bouclier à valeur des stats 0
        // pour signifier le pas de bouclier
        boucliers = new Boucliers("aucun", 0, 0);
        listBoucliers.add(boucliers);

        for (int i = 0; i <= nbBoucliers ; i++) {
            String nom = bouclierNom[new Random().nextInt(bouclierNom.length)];
            Integer defense = new Random().nextInt(5,21);
            Integer poids = new Random().nextInt(5000,10001);
            boucliers = new Boucliers(nom, defense, poids);
            listBoucliers.add(boucliers);
        }
        return listBoucliers;
    }
    /**
     * Crée une liste de nourritures contenues dans la sacoche
     * le nombre d'items est aléatoire
     * @return
     */
    public static List<Nourritures> buildNourriture(){
        Integer nbNourriture = new Random().nextInt(1,6);
        List<Nourritures> listNourritures = new ArrayList<>();
        Nourritures nourritures;
        for (int i = 0; i <= nbNourriture ; i++) {
            String nom = nourritureNom[new Random().nextInt(nourritureNom.length)];
            Integer nbPointdevie = new Random().nextInt(1,21);
            Integer nbEndurance = new Random().nextInt(1,21);
            Integer poids = new Random().nextInt(50,201);
            nourritures = new Nourritures(nom, nbPointdevie, nbEndurance, poids);
            listNourritures.add(nourritures);
        }
        return listNourritures;
    }

    /**
     * Tableau des noms de bouclier
     */
    public static String[] bouclierNom = new String[] {
            "rundskjold", "Skjaldmo", "Adarga", "Broquel", "Aspis", "Clipeus", "Pavois", "Rondache", "Targe", "Tarja", "ecu"
    };

    /**
     * Tableau des noms de nourriture
     */
    public static String[] nourritureNom = new String[] {
            "gâteau", "ragoût de lapin", "champignons", "saumon Cuit", "pain", "pommes", "pomme de terre au four",
            "charlotte aux Fraises", "artichauts", "banane", "tomate", "verre de lait", "pâtes au fromage"
    };

}
