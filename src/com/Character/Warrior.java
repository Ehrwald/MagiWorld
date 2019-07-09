package com.Character;

import com.Exception.InvalidLvlException;
import com.Exception.TooHightAttributesException;

public class Warrior extends Character {



    public Warrior(int numPlayer, int str, int agi, int intel, int basicAttack, int specialAttack, int lvl) throws InvalidLvlException, TooHightAttributesException {
        super(numPlayer, str, agi, intel, basicAttack, specialAttack, lvl);
    }

    @Override
    public void basicAtk(Character enemy) {

        this.basicAttack = this.str;
        System.out.println("Joueur " +this.numPlayer+ " utilise Coup d’Épée et inflige " + this.basicAttack +
                " de point de dégat.");
        enemy.vit-= this.basicAttack;
        System.out.println(" Et le joueur " + enemy.numPlayer + " perd " + this.basicAttack + " point de vie");




    }

    @Override
    public void specialAtk(Character enemy) {

        this.specialAttack = this.str *2;
        System.out.println("Joueur " +this.numPlayer+ " utilise Coup de Rage et inflige " + this.specialAttack +
                " de point de dégat.");
        enemy.vit -= this.specialAttack;
        System.out.println(" Et le joueur " + enemy.numPlayer + " perd " + this.specialAttack + " point de vie");
        this.vit -= this.str /2;
        System.out.println(" Mais le joueur " +this.numPlayer+ " perd lui aussi " + this.str /2 + " point de vie");




    }


}
