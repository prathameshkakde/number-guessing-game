package com.prathamesh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* Tests for Number Guessing Game logic
*/
public class MainTest {

    /*
    * Test low guess
    */
    @Test
    void testTooLowGuess() {

        Main game = new Main();

        game.setSecretNumber(50);

        String result = game.checkGuess(25);

        assertEquals("Too low!", result);
    }

    /*
     * Test high guess
     */
    @Test
    void testTooHighGuess() {

        Main game = new Main();

        game.setSecretNumber(50);

        String result = game.checkGuess(75);

        assertEquals("Too high!", result);
    }

    /*
     * Test correct guess
     */
    @Test
    void testCorrectGuess() {

        Main game = new Main();

        game.setSecretNumber(50);

        String result = game.checkGuess(50);

        assertEquals("Correct!", result);
    }
}
