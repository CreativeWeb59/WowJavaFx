package fr.wowjavafx.controllers;

import fr.wowjavafx.world.Monde;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

public class MainController {
    @FXML
    private Label labelConsole;
    @FXML
    private Button btnJouer, btnTourSuivant;
    // Declaration des images héros et monstres
    @FXML
    private ImageView hero1, hero2, monstre1, monstre2;

    private String imgHeroDefaut = "heroDefaut";
    private String imgMonstreDefaut = "monstreDefaut";

    private String messageConsole;
    private Monde m;

    public void LancerJeu() throws IOException {
        this.m = new Monde(this);

        System.out.println("Création du monde");
        messageConsole = "Création du monde" + System.getProperty("line.separator");
        messageConsole += "Le monde est crée" + System.getProperty("line.separator");
        messageConsole += "Lancement des combats" + System.getProperty("line.separator");

        // creation du monde
        // et creation des équipes
        m.lancementJeu();
        System.out.println("Le monde est créée");
        System.out.println("Lancement des combats");

        // Affichage des images des combattants
        AttribuerImages(m.imageHero(0), m.imageHero(1), m.imageMonstre(0), m.imageMonstre(1));

        /*boolean condition = true;
        while(condition){
            condition = m.demarrer();
        }
        m.teamWinner();

         */
    }


    public void LancerTourSuivant() throws IOException{
        this.m.demarrerTour();
        System.out.println("Tour suivant");
    }

    public void AttribuerImages(String nomHero1, String nomHero2, String nomMonstre1, String nomMonstre2){

        // l'image des héros
        try {
            Image imageHero1 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + nomHero1 + ".png"));
            hero1.setImage(imageHero1);
        } catch (NullPointerException e) {
            Image imageHero1 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + imgHeroDefaut + ".png"));
            hero1.setImage(imageHero1);
        }

        try {
            Image imageHero2 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + nomHero2 + ".png"));
            hero2.setImage(imageHero2);
        } catch (NullPointerException e) {
            Image imageHero2 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + imgHeroDefaut + ".png"));
            hero2.setImage(imageHero2);
        }

        // l'image des monstres
        try {
            Image imageMonstre1 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + nomMonstre1 + ".png"));
            monstre1.setImage(imageMonstre1);
        } catch (NullPointerException e) {
            Image imageMonstre1 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + imgMonstreDefaut + ".png"));
            monstre1.setImage(imageMonstre1);
        }

        try {
            Image imageMonstre2 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + nomMonstre2 + ".png"));
            monstre2.setImage(imageMonstre2);
        } catch (NullPointerException e) {
            Image imageMonstre2 = new Image(getClass().getResourceAsStream("/fr/wowjavafx/images/" + imgMonstreDefaut + ".png"));
            monstre2.setImage(imageMonstre2);
        }
    }

    /**
     * Affiche le message passé en argument dans le label
     * @param messageLabel
     */
    public void afficherDansLabel(String messageLabel){
        this.labelConsole.setText(messageLabel);
    }

}