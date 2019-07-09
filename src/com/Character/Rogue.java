package com.Character;

import com.Exception.InvalidLvlException;
import com.Exception.TooHightAttributesException;

public class Rogue extends Character {

    public Rogue(int numPlayer, int vit, int str, int agi, int intel, int basicAttack, int specialAttack, int lvl) throws InvalidLvlException, TooHightAttributesException {
        super(numPlayer, str, agi, intel, basicAttack, specialAttack, lvl);
    }

    @Override
    public void basicAtk(Character enemy) {
        this.basicAttack = this.agi;
        System.out.println("Joueur " +this.numPlayer+ " utilise Tir à l'Arc et inflige " + this.basicAttack +
                " de point de dégat.");
        enemy.vit-= this.basicAttack;
        System.out.println(" Et le joueur " + enemy.numPlayer + " perd " + this.basicAttack + " point de vie");
    }

    @Override
    public void specialAtk(Character enemy) {
        this.specialAttack = this.agi += this.lvl*2;
        System.out.println("Joueur " + this.numPlayer+ " utilise Concentration et augemente de " + this.specialAttack +
                " son agilité.");
    }

    @Override
    public int maxLifePoint() {
        return super.maxLifePoint();
    }
}



