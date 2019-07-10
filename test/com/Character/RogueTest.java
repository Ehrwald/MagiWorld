package com.Character;

import com.Exception.InvalidNiveauException;
import com.Exception.TooHighAttributesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {

    class RodeurTest {

        private Rogue barbare;
        private Rogue genie;
        private Rogue archer;


        @BeforeEach
        private void init() {
            try {
                this.barbare = new Rogue(100, 100, 0, 0, "berserker");
                this.genie = new Rogue(100, 10, 10, 80, "Leonard");
                this.archer = new Rogue(100, 10, 80, 10, "Robin");
            } catch (TooHighAttributesException e) {
                System.err.println("Le niveau du guerrier est trop bas pour autant d'attributs");
                e.printStackTrace();
            } catch (InvalidNiveauException e) {
                System.err.println("Le niveau du guerrier est trop élevé");
                e.printStackTrace();
            }
        }

        @Test
        void testRodeur() {
            assertEquals(barbare.nomAttaqueBasique, "Tir à l'arc");
            assertEquals(barbare.nomAttaqueSpeciale, "Concentration");
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
            assertEquals(archer.getVie(), 500);
            assertEquals(genie.getVie(), 500);

            archer.attaqueBasique(genie);
            assertEquals(genie.getVie(), 420);
            assertEquals(archer.getVie(), 500);
        }


        @Test
        void testAttaqueSpeciale1() {
            assertEquals(barbare.getVie(), 500);
            assertEquals(genie.getVie(), 500);
            assertEquals(archer.getVie(), 500);

            assertEquals(barbare.agilite, 0);
            assertEquals(genie.agilite, 10);
            assertEquals(archer.agilite, 80);

            barbare.attaqueSpeciale(genie);
            assertEquals(barbare.agilite, 50);

            genie.attaqueSpeciale(archer);
            assertEquals(genie.agilite, 60);


            archer.attaqueSpeciale(barbare);
            assertEquals(archer.agilite, 130);

            assertEquals(barbare.getVie(), 500);
            assertEquals(genie.getVie(), 500);
            assertEquals(archer.getVie(), 500);
        }

    }

}