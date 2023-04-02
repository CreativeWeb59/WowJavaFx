package fr.wowjavafx.world;

import fr.wowjavafx.actions.Combat;
import fr.wowjavafx.controllers.MainController;
import fr.wowjavafx.factory.HerosFactory;
import fr.wowjavafx.factory.MonstreFactory;


import java.io.IOException;
import java.util.Random;

public class Monde {

    // Création des équipes
    Equipe heros = new Equipe();
    Equipe monstres = new Equipe();

    MainController fenetrePrincipale;

    /**
     * Constructeur qui recupere l'instance de la fenetre JavaFx
     * @param fenetrePrinciaple
     * @throws IOException
     */
    public Monde(MainController fenetrePrinciaple) throws IOException {
        this.fenetrePrincipale = fenetrePrinciaple;
    }
    /**
     * Methode qui regroupe les différents objets à instancier
     * crée les équipes de héros et monstres
     * crée les armes, les boucliers, les nourritures
     * crée la sacoche pour chaque combattant
     * attribue, les armes, boucliers et nourriture
     */
    public void lancementJeu() {

        // Création des Heros & Monstres et ajout aux équipe spécifique

        heros.addFighter(HerosFactory.build());
        heros.addFighter(HerosFactory.build());
        monstres.addFighter(MonstreFactory.build());
        monstres.addFighter(MonstreFactory.build());

        // Ajout de la sacoche aux Héros et Monstres
        heros.addSacoche();
        monstres.addSacoche();

        // Ajout des armes aux Héros & Monstres -> appelé dans addSacoche()
        heros.equipeArme();
        monstres.equipeArme();

        heros.equipeBouclier();
        monstres.equipeBouclier();

        fenetrePrincipale.afficherDansLabel("Création des équipes");
    }

    /**
     * Methode qui boucle sur l'équipe des héros et des monstres pour executer les combats ou les actions
     * @return un boolean pour savoir si l'équipe est en vie ou non
     */
    public boolean demarrer() throws IOException {
        boolean etat;
        boolean tourJeux = new Random().nextBoolean();
       try{
           if (tourJeux){
               Combat.combat(heros.chooseFighter(), monstres.chooseFighter());
               etat = heros.isDead();
               return !etat;
           }else {
               Combat.combat(monstres.chooseFighter(), heros.chooseFighter());
               etat = monstres.isDead();
               return !etat;
           }
        } catch (Exception e) {
            return true;
        }
    }
    /**
     * Lance un assaut du combat
     * recupere un tableau et affiche le résultat de l'assaut dans la fenetre principale
     * contenu du tableau :
     * - hero inflige 10 degats
     * @return
     * @throws IOException
     */
    public boolean demarrerTour() throws IOException {
        boolean etat;
        boolean tourJeux = new Random().nextBoolean();
        //System.out.println(heros.size()+" "+monstres.size());
        try{
            if (tourJeux){
                // Combat.tourCombat(heros.chooseFighter(), monstres.chooseFighter());
                fenetrePrincipale.afficherDansLabel(Combat.tourCombat(heros.chooseFighter(), monstres.chooseFighter()));
                etat = heros.isDead();
                return !etat;
            }else {
                // Combat.tourCombat(monstres.chooseFighter(), heros.chooseFighter());
                etat = monstres.isDead();
                fenetrePrincipale.afficherDansLabel(Combat.tourCombat(monstres.chooseFighter(), heros.chooseFighter()));
                return !etat;
            }
        } catch (Exception e) {
            return true;
        }
    }
    /**
     * retourne l'équipe gagnante
     * @return
     */
    public void teamWinner(){
       if (heros.size() == 0){
            System.out.println("Les monstres ont gagné !");
       }else if (monstres.size() == 0) {
            System.out.println("Les héros ont gagné !");
        }else{
            System.out.println("Pas de vainqueur !");
        }
    }
    /**
     * retourne le nom passé en parametre
     * ce nom subit un traitement = full minuscule
     * et pas d'espace
     * sert pour attribuer le fichier image correspondant
     * @return
     */
    public String imageHero(int index) {
        String nomImage = heros.getNomImage(index);
        nomImage = nomImage.toLowerCase();
        nomImage = nomImage.trim();
        return nomImage;
    }

    /**
     * Recupere uniquement le nom du monstre (et non le prenom)
     * @param index
     * @return
     */
    public String imageMonstre(int index) {
        String nomImage = monstres.getNomImage(index);
        nomImage = nomImage.toLowerCase();
        int espace = nomImage.indexOf(" ");
        if (espace > 0){
            nomImage = nomImage.substring(0, espace);
        }
        return nomImage;
    }
}