package org.deroesch.lambdas.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void testGetOne() {
        assertEquals(State.PA, State.getOne("Pennsylvania").orElseThrow(IllegalArgumentException::new));
        assertEquals("PA", State.getOne("Pennsylvania").orElseThrow(IllegalArgumentException::new).shortName());

        assertThrows(IllegalArgumentException.class, () -> {
            State.getOne("Foobar").orElseThrow(IllegalArgumentException::new);
        });
    }

}
