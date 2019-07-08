package com.Character;

public class Wizard extends Character {

    public Wizard(int numPlayer, int vit, int str, int agi, int intel, int basicAttack, int specialAttack, int lvl) {
        super(numPlayer, vit, str, agi, intel, basicAttack, specialAttack, lvl);
    }

    @Override
    public void basicAtk(Character enemy) {

        this.basicAttack = this.str;
        System.out.println("Joueur " +this.numPlayer+ " utilise Boule de Feu et inflige " + this.basicAttack +
                " de point de dégat.");
        enemy.vit-= this.basicAttack;
        System.out.println(" Et le joueur " + enemy.numPlayer + " perd " + this.basicAttack + " point de vie");
    }

    @Override
    public void specialAtk(Character enemy) {

        this.specialAttack = this.intel *2;
        this.vit += this.specialAttack;
        if(this.vit < maxLifePoint(this.lvl))
            this.vit = maxLifePoint(this.lvl);

        /*

        if (this.vit < maxLifePoint(this.lvl)){
            this.vit += this.specialAttack;
            System.out.println("Joueur " + this.numPlayer + " utilise Soin et récupère  " + this.specialAttack +
            " de point de vie.");
        } else (this.specialAttack + this.vit > maxLifePoint(this.lvl)){

        }
*/

    }


    public int maxLifePoint(int lvl) {

        return lvl*5;

    }

    public static void main(String[] args) {
        Wizard w = new Wizard(1, 5,5,5,5,5,5,5);
        System.out.println(w.getLvl());
        w.specialAtk(w);

        Warrior wa = new Warrior(2,2,2,2,2,22,2,2);
        wa.specialAtk(w);
        w.specialAtk(w);


    }

}
