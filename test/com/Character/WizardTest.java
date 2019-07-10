package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    private Wizard barbare;
    private Wizard genie;
    private Wizard aouch;

    @BeforeEach
    private void init() {
        try {
            this.barbare = new Wizard(100, 100, 0, 0, "berserker");
            this.genie = new Wizard(100, 10, 10, 80, "Leonard");
            this.aouch = new Wizard(100, 10, 10, 80, "disciple");
            this.aouch.prendreDegats(200);
        } catch (TooHighAttributesException e) {
            System.err.println("Le niveau du mage est trop bas pour autant d'attributs");
            e.printStackTrace();
        } catch (InvalidNiveauException e) {
            System.err.println("Le niveau du mage est trop élevé");
            e.printStackTrace();
        }
    }

    @Test
    void testMage() {
        assertEquals(barbare.nomAttaqueBasique, "Boule de feu");
        assertEquals(barbare.nomAttaqueSpeciale, "Soin");
    }

    @Test
    void testAttaqueBasique() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);

        barbare.attaqueBasique(genie);
        assertEquals(genie.getVie(), 500);
        assertEquals(barbare.getVie(), 500);
    }

    @Test
    void testAttaqueBasique2() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);

        genie.attaqueBasique(barbare);
        assertEquals(genie.getVie(), 500);
        assertEquals(barbare.getVie(), 420);
    }

    @Test
    void testAttaqueSpeciale1() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);
        assertEquals(aouch.getVie(), 300);

        barbare.attaqueSpeciale(genie);
        assertEquals(genie.getVie(), 500);
        assertEquals(barbare.getVie(), 500);

        aouch.attaqueSpeciale(genie);
        assertEquals(aouch.getVie(), 460);

        aouch.vie = 490;
        aouch.attaqueSpeciale(genie);
        assertEquals(aouch.getVie(), 500);
    }
}