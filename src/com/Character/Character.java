package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;

public abstract class Character implements Attaquant{



    protected int niveau=0;
    protected int vie=0;
    protected int force=0, agilite=0, intelligence=0;
    protected String nom="";
    protected String nomAttaqueBasique="";
    protected String nomAttaqueSpeciale="";

    /**
     * instancie un héro en lui attribuant une vie 5* supérieur au niveau
     * @param niveau
     * @param force
     * @param agilite
     * @param intelligence
     * @param nom
     * @throws TooHighAttributesException si la sommes des attributs est supérieure au niveau
     * @throws InvalidNiveauException si le niveau est supérieur à 100
     */
    public Character(int niveau, int force, int agilite, int intelligence, String nom)
            throws TooHighAttributesException, InvalidNiveauException {
        int attributs = force+agilite+intelligence;
        if(attributs > niveau)
            throw new TooHighAttributesException(
                    "La somme des attribues ("+attributs+") ne peux pas être supérieure au niveau du héro ("
                            +niveau+")");
        if(niveau<1 || niveau > 100)
            throw new InvalidNiveauException("Le niveau "+niveau+ " n'est pas autorisé (max 100)");
        this.niveau = niveau;
        this.vie = niveau*5;
        this.force = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        this.nom = nom;
    }


    /**
     * inflige des dégats au personnage et le signal en écrivant un message de suivit
     * si la vitalité passe à 0, affiche que le personnage est mort
     * @param degats
     */
    public void prendreDegats(int degats) {
        System.out.println(this.nom + " perd " + degats + " points de vie.");
        this.vie -= degats;
        if(this.vie<1) {
            this.vie = 0;
            System.out.println(this.nom + " est mort!");
        }
    }

    public int getVie() {
        return this.vie;
    }

    /**
     * permet de savoir si le personnage est en vie
     * @return
     */
    public boolean estVivant() {
        return this.vie>0;
    }

    public String getNom() {
        return this.nom;
    }

    public String getNomAttaqueBasique() {
        return nomAttaqueBasique;
    }

    public String getNomAttaqueSpeciale() {
        return nomAttaqueSpeciale;
    }

    /**
     * renvoit un message de présentation du personnage
     * @return
     */
    public String getDescription() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.nom);
        sb.append(" niveau ").append(this.niveau);
        sb.append(" je possède ").append(this.vie).append(" de vitalité, ");
        sb.append(this.force).append(" de force, ");
        sb.append(this.agilite).append(" d'agilité ");
        sb.append(this.intelligence).append(" d'intelligence !");
        return sb.toString();
    };

}

