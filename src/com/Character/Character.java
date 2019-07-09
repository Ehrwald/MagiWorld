package com.Character;

import com.Exception.InvalidLvlException;
import com.Exception.TooHightAttributesException;

public abstract class Character {



    protected int numPlayer;
    protected int vit;
    protected int str;
    protected int agi;
    protected int intel;
    protected int basicAttack;
    protected int specialAttack;
    protected int lvl;
    protected String nom = "";

    public Character(int numPlayer, int str, int agi, int intel, int basicAttack, int specialAttack, int lvl) throws TooHightAttributesException, InvalidLvlException {
        this.numPlayer = numPlayer;
        this.lvl = lvl;
        this.vit = maxLifePoint();
        this.str = str;
        this.agi = agi;
        this.intel = intel;
        this.nom = nom;
        this.basicAttack = basicAttack;
        this.specialAttack = specialAttack;
        int attributs = str + agi + intel;
            if (attributs > lvl){
                throw new TooHightAttributesException("la somme des attribues (" + attributs + ") ne peux pas être supérieur au niveau du personnage (" + lvl + ")");
            }
            if (lvl<1 || lvl>100){
                throw new InvalidLvlException("Le niveau " +lvl+ " dois être supérieur à 1 et inférieur à 100.");
            }
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

    public boolean estVivant() {
        return this.vit>0;
    }

    public String getNom() {
        return this.nom;
    }

    public String getDescription() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.nom);
        sb.append(" niveau ").append(this.lvl);
        sb.append(" je possède ").append(this.vit).append(" de vitalité, ");
        sb.append(this.str).append(" de force, ");
        sb.append(this.agi).append(" d'agilité");
        sb.append(this.intel).append(" d'intelligence !");
        return sb.toString();
    };

}

