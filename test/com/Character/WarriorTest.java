package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior barbare;
    private Warrior genie;
    private Warrior aouch;


    @BeforeEach
    private void init() {
        try {
            this.barbare = new Warrior(100, 100, 0, 0, "berserker");
            this.genie = new Warrior(100, 10, 10, 80, "Leonard");
            this.aouch = new Warrior(100, 10, 10, 80, "disciple");
            this.aouch.prendreDegats(200);
        } catch (TooHighAttributesException e) {
            System.err.println("Le niveau du guerrier est trop bas pour autant d'attributs");
            e.printStackTrace();
        } catch (InvalidNiveauException e) {
            System.err.println("Le niveau du guerrier est trop élevé");
            e.printStackTrace();
        }
    }

    @Test
    void testGuerrier() {
        assertEquals(barbare.nomAttaqueBasique, "Coup d'épée");
        assertEquals(barbare.nomAttaqueSpeciale, "Coup de rage");
    }

    @Test
    void testAttaqueBasique() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);

        barbare.attaqueBasique(genie);
        assertEquals(genie.getVie(), 400);
        assertEquals(barbare.getVie(), 500);
    }

    @Test
    void testAttaqueBasique2() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);

        genie.attaqueBasique(barbare);
        assertEquals(barbare.getVie(), 490);
        assertEquals(genie.getVie(), 500);
    }

    @Test
    void testAttaqueSpeciale1() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);

        barbare.attaqueSpeciale(genie);
        assertEquals(genie.getVie(), 300);
        assertEquals(barbare.getVie(), 450);
    }


    @Test
    void testAttaqueSpeciale2() {
        assertEquals(barbare.getVie(), 500);
        assertEquals(genie.getVie(), 500);

        genie.attaqueSpeciale(barbare);
        assertEquals(genie.getVie(), 495);
        assertEquals(barbare.getVie(), 480);
    }
}