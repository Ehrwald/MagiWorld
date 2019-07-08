package com.Character;

public abstract class Character {



    protected int numPlayer;
    protected int vit;
    protected int str;
    protected int agi;
    protected int intel;
    protected int basicAttack;
    protected int specialAttack;
    protected int lvl;

    public Character(int numPlayer, int str, int agi, int intel, int basicAttack, int specialAttack, int lvl) {
        this.numPlayer = numPlayer;
        this.lvl = lvl;
        this.vit = maxLifePoint();
        this.str = str;
        this.agi = agi;
        this.intel = intel;
        this.basicAttack = basicAttack;
        this.specialAttack = specialAttack;
    }

    public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getBasicAttack() {
        return basicAttack;
    }

    public void setBasicAttack(int basicAttack) {
        this.basicAttack = basicAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public abstract void basicAtk(Character enemy);

    public abstract void specialAtk(Character enemy);

    public int maxLifePoint(){
       return this.lvl*5;
    }


    // TODO: calculer la vie sur le niveau *5.
    //TODO niveau choisi par le joueur min 1 et le total de point de caractéristiques doit pas excéder le niveau.
}

