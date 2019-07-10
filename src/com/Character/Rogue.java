package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;

public class Rogue extends Character {

    public Rogue(int niveau, int force, int agilite, int intelligence, String nom)
            throws TooHighAttributesException, InvalidNiveauException {
        super(niveau, force, agilite, intelligence, nom);
        this.nomAttaqueBasique = "Tir à l'arc";
        this.nomAttaqueSpeciale = "Concentration";
    }

    @Override
    public void attaqueBasique(Character cible) {
        System.out.println(this.nom + " utilise " + this.nomAttaqueBasique +" et inflige " + this.agilite +
                " domages.");
        cible.prendreDegats(this.agilite);
    }

    @Override
    public void attaqueSpeciale(Character cible) {
        System.out.println(this.nom + " utilise " + this.nomAttaqueSpeciale +" et augmente son agilité de " +
        this.niveau/2 + " points.");
        this.agilite += this.niveau/2;
    }



    @Override
    public String getDescription() {
        return "Vous êtes dans ma ligne de mire! Je suis le Rôdeur" + super.getDescription();
    }
}



