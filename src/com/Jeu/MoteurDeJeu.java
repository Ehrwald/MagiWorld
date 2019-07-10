package com.Jeu;

import com.Character.Character;
import com.Character.Rogue;
import com.Character.Warrior;
import com.Character.Wizard;
import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;

import java.util.Scanner;

public class MoteurDeJeu {

    private Scanner reader;
    private Character joueur1,joueur2;

    /**
     * initialise les outils pour interagir avec l'utilisateur et lance une partie
     */
    public MoteurDeJeu() {

        this.reader = new Scanner(System.in);

        this.newGame();
    }

    /**
     * Propose aux utilisateurs de créer chacun leur joueur et gère l'affrontement jusqua la mort
     */
    private void newGame() {
        try {
            this.joueur1 = this.newPlayer("Joueur 1");
            System.out.println(this.joueur1.getDescription());
            this.joueur2 = this.newPlayer("Joueur 2");
            System.out.println(this.joueur2.getDescription());

            Character attaquant = joueur1;
            Character cible = joueur2;
            while (this.joueur1.estVivant() && this.joueur2.estVivant()) {
                this.heroTurn(attaquant, cible);
                //gestion de l'alternance des joueurs
                Character tmp = attaquant;
                attaquant = cible;
                cible = tmp;
            }
            //redéfinir la cible comme le hero qui vient de mourir
            cible = attaquant;
            this.claimWinner(cible);


        } catch (TooHighAttributesException | InvalidNiveauException e) {
            System.err.println("Mauvais parametres dans la création du joueur");
            e.printStackTrace();
        }
    }

    /**
     * gère la création d'un joueur en proposant à l'utilisateur de le paramétrer
     * @param nom : le nom qui sera attribué au joueur
     * @return
     * @throws TooHighAttributesException en cohérence avec le constructeur du héro
     * @throws InvalidNiveauException en cohérence avec le constructeur du héro
     */
    private Character newPlayer(String nom) throws TooHighAttributesException, InvalidNiveauException {

        int type = this.demander("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rodeur, " +
                "3: Mage");
        int niveau = this.demander("Niveau du personnage ?");
        int force = this.demander("Force du personnage ?");
        int agilite = this.demander("Agilité du personnage ?");
        int intelligence = this.demander("Intelligence du personnage ?");

        return this.character(type, niveau, force, agilite, intelligence, nom);
    }

    /**
     * permet de demander à un utilisateur d'entrer une valeur en lui indiquant ce que l'on souhaite comme renseignement
     * @param info : le message d'information à afficher à l'utilisateur
     * @return
     */
    private int demander(String info) {
        System.out.println(info);
        return reader.nextInt();
    }

    /**
     * Créer un Hero en fonction des paramettres de l'utilisateur
     * @param type
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param nom
     * @return
     * @throws TooHighAttributesException
     * @throws InvalidNiveauException
     */
    private Character character(int type, int niveau, int force, int agilite, int intelligence, String nom)
            throws InvalidNiveauException, TooHighAttributesException {
        switch (type) {
            case 1:
                return new Warrior(niveau, force, agilite, intelligence, nom);
            case 2:
                return new Rogue(niveau, force, agilite, intelligence, nom);
            case 3:
                return new Wizard(niveau, force, agilite, intelligence, nom);
            default:
                return null;
        }
    }

    /**
     * gère le tour d'un joueur qui en attaque un autre
     * @param attaquant
     * @param cible
     */
    private void heroTurn(Character attaquant, Character cible) {
        int attaque = this.demander(attaquant.getNom() + " (" +attaquant.getVie() +
                " vitalité) Veuillez choisir votre action (1: attaque basique, 2: attaque spéciale)");
        switch (attaque) {
            case 1:
                attaquant.attaqueBasique(cible);
                break;
            case 2:
                attaquant.attaqueSpeciale(cible);
                break;
            default:
                System.out.println("Mauvaise entrée, "+ attaquant.getNom()+ " passe son tour");
        }
        System.out.println("");
    }


    /**
     * gère le message de fin de partie en désignant le héro mort
     * @param mort
     */
    private void claimWinner(Character mort) {
        System.out.println(mort.getNom() + " a perdu");
    }
}
