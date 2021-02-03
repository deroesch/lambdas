package org.deroesch.lambdas;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testMain() {
        new App().main(null);
        assertTrue(true);
    }

}
