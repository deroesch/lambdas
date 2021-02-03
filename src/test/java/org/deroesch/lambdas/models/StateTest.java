package org.deroesch.lambdas.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StateTest {

    @Test
    void testEquality() {
        assertSame(State.CA, State.CA);
        assertNotSame(State.OK, State.CA);
    }

    @Test
    void testGetter() {
        assertEquals("PA", State.PA.shortName());
        assertEquals("Pennsylvania", State.PA.getLongName());
    }

    @Test
    void testGetStates() {
        assertTrue(State.getAll().containsKey("Pennsylvania"));
        assertEquals(State.PA, State.getAll().get("Pennsylvania"));
        assertEquals("PA", State.getAll().get("Pennsylvania").shortName());
    }

}
