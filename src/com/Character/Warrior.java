package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;

public class Warrior extends Character {

    public Warrior(int niveau, int force, int agilite, int intelligence, String nom)
            throws TooHighAttributesException, InvalidNiveauException {
        super(niveau, force, agilite, intelligence, nom);
       this.nomAttaqueBasique = "Coup d'épée";
       this.nomAttaqueSpeciale = "Coup de rage";
    }

    @Override
    public void attaqueBasique(Character cible) {
        System.out.println(this.nom + " utilise " + this.nomAttaqueBasique +" et inflige " + this.force + " domages.");
        cible.prendreDegats(this.force);
    }

    @Override
    public void attaqueSpeciale(Character cible) {
        System.out.println(this.nom + " utilise " + this.nomAttaqueSpeciale +" et inflige " +this.force + " domages.");
        cible.prendreDegats(this.force*2);
        this.prendreDegats(this.force/2);
    }

    @Override
    public String getDescription() {
        return "For the King! Je suis le Guerrier " + super.getDescription();
    }
}
