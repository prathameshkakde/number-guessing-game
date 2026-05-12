package com.prathamesh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* Basic JUnit test class
*/
public class MainTest {

    /*
    * Test simple addition
    */
    @Test
    void  testAddition() {

        // Expected result
        int expected = 5;

        // Actual result
        int actual = 2 + 3;

        // Verify both values match
        assertEquals(expected, actual);
    }
}
