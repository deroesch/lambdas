package org.deroesch.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.deroesch.lambdas.models.TeamMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class TeamMemberTest {

    TeamMember c1;
    TeamMember c2;

    @SuppressWarnings("null")
    private static final Class<NullPointerException> NPE = NullPointerException.class;

    @BeforeEach
    void beforeEach() {
        c1 = new TeamMember("a", "b", "c");
        c2 = new TeamMember(c1);
    }

    @Test
    void testCreated() {
        assertNotNull(c1);
        assertNotNull(c2);

        assertTrue(TeamMember.EMPTY.isEmpty());
        assertFalse(c1.isEmpty());
    }

    @Test
    void testConstructor() {
        assertThrows(NPE, () -> {
            new TeamMember(null, "", "");
        });

        assertThrows(NPE, () -> {
            new TeamMember("", null, "");
        });

        assertThrows(NPE, () -> {
            new TeamMember("", "", null);
        });
    }

    @Test
    void testSetter() {
        assertThrows(NPE, () -> {
            c1.setLongevity(null);
        });
    }

    @Test
    void testEquals() {
        assertSame(c1, c1);
        assertEquals(c1, c1);
        assertEquals(c1, c2);
        assertNotEquals(c1, new Object());

        TeamMember c3 = new TeamMember(c1);
        c3.setName("foo");
        assertNotEquals(c1, c3);

        c3 = new TeamMember(c1);
        c3.setEmail("foo");
        assertNotEquals(c1, c3);

        c3 = new TeamMember(c1);
        c3.setPhone("foo");
        assertNotEquals(c1, c3);

        final TeamMember c4 = new TeamMember(c1);
        assertThrows(NPE, () -> {
            c4.setName(null);
        });

        assertThrows(NPE, () -> {
            c4.setEmail(null);
        });

        assertThrows(NPE, () -> {
            c4.setPhone(null);
        });
    }

    @Test
    void testHashCode() {
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("TeamMember [name=a, email=b, phone=c]", c1.toString());
    }
}
