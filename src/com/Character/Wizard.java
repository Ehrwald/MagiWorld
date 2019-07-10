package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;

public class Wizard extends Character {

    public Wizard(int niveau, int force, int agilite, int intelligence, String nom)
            throws TooHighAttributesException, InvalidNiveauException {
        super(niveau, force, agilite, intelligence, nom);
        this.nomAttaqueBasique = "Boule de feu";
        this.nomAttaqueSpeciale = "Soin";
    }

    @Override
    public void attaqueBasique(Character cible) {
        System.out.println(this.nom + " utilise " + this.nomAttaqueBasique + " et inflige " + this.intelligence +
                " domages.");
        cible.prendreDegats(this.intelligence);
    }

    @Override
    public void attaqueSpeciale(Character cible) {
        int vieilleVie = this.vie;
        this.vie += this.intelligence*2;
        if(this.vie > this.niveau*5)
            this.vie = this.niveau*5;

        int soigne = this.vie - vieilleVie;
        System.out.println(this.nom + " utilise " + this.nomAttaqueSpeciale +" et se soigne de  " + soigne +
                " domages.");
    }

    @Override
    public String getDescription() {
        return "Le savoir est la clef! Je suis le Mage " + super.getDescription();
    }


}
