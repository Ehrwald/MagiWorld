package com.Character;

public class Rogue extends Character {

    public Rogue(int numPlayer, int vit, int str, int agi, int intel, int basicAttack, int specialAttack, int lvl) {
        super(numPlayer, vit, str, agi, intel, basicAttack, specialAttack, lvl);
    }

    @Override
    public void basicAtk(Character enemy) {

    }

    @Override
    public void specialAtk(Character enemy) {

    }

    @Override
    public int maxLifePoint(int lvl) {

        this.lvl =  lvl * 5;
        return lvl;
    }


}
