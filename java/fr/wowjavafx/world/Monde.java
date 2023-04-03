package fr.wowjavafx.world;

import fr.wowjavafx.actions.Combat;
import fr.wowjavafx.controllers.MainController;
import fr.wowjavafx.factory.HerosFactory;
import fr.wowjavafx.factory.MonstreFactory;


import java.io.IOException;
import java.util.*;

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

        String messageFenetrePrincipale;
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

        messageFenetrePrincipale = "Les équipes se préparent à combattre,\n";
        messageFenetrePrincipale += "L'équipe des héros est composée de :\n" + heros.get(0).getNom() + " et " + heros.get(1).getNom() + ",\n";
        messageFenetrePrincipale += "L'équipe des monstres est composée de :\n" + monstres.get(0).getNom() + " et " + monstres.get(1).getNom() + ".\n";
        fenetrePrincipale.afficherDansLabel(messageFenetrePrincipale);

    }

    /**
     * Methode qui boucle sur l'équipe des héros et des monstres pour executer les combats ou les actions
     * @return un boolean pour savoir si l'équipe est en vie ou non
     */
    public boolean demarrer() throws IOException {
        String resultat[];
        boolean etat;
        boolean tourJeux = new Random().nextBoolean();
       try{
           if (tourJeux){
               Combat.combat(heros.chooseFighter(), monstres.chooseFighter());
               resultat = heros.isDead();
               etat = Boolean.parseBoolean(resultat[0]);
               return !etat;
           }else {
               Combat.combat(monstres.chooseFighter(), heros.chooseFighter());
               resultat = monstres.isDead();
               etat = Boolean.parseBoolean(resultat[0]);
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
        String resultat[];
        Boolean etat;
        boolean tourJeux = new Random().nextBoolean();
        // Stocke les messages à afficher dans le label
        List<String> messageFenetre = new ArrayList<>();
        //System.out.println(heros.size()+" "+monstres.size());
        try{
            if (tourJeux){
                // Combat.tourCombat(heros.chooseFighter(), monstres.chooseFighter());
                messageFenetre.addAll(Combat.tourCombat(heros.chooseFighter(), monstres.chooseFighter()));
                fenetrePrincipale.afficherDansLabel(messageFenetre);
                resultat = heros.isDead();
                etat = Boolean.parseBoolean(resultat[0]);
                messageFenetre.add(resultat[1]);
                return !etat;
            }else {
                // Combat.tourCombat(monstres.chooseFighter(), heros.chooseFighter());
                resultat = monstres.isDead();
                etat = Boolean.parseBoolean(resultat[0]);
                messageFenetre.add(resultat[1]);
                messageFenetre.addAll(Combat.tourCombat(monstres.chooseFighter(), heros.chooseFighter()));
                fenetrePrincipale.afficherDansLabel(messageFenetre);
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

    /**
     * traitement du tableau des résultats
     * besoins :
     * 1er tableau : nom attaquant - action(attaquer/manger/repos) - pv (debut) - endu (debut) - dégats - perte endu - arme
     * 2ème tableau : nom defenseur - bouclier(oui/non) - pv (debut) - endu (debut) - dégats subis - perte endu - blocage
     * 3ème tableau : nourriture - pv - endu
     * 4ème tableau : résultat du combat : continue ou non du vainqueur
     */

}