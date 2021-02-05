package org.deroesch.lambdas.models;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@DisplayName("A TeamMember should ")
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
    @DisplayName("throw NPEs when setters have null arguments.")
    void testSetters() {

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

        assertThrows(NPE, () -> {
            c1.setLongevity(null);
        });
    }

    @Nested
    @DisplayName("on creation")
    class Creation {

        @Test
        @DisplayName("never be empty.")
        void testCreated() {
            assertNotNull(c1);
            assertNotNull(c2);

            assertTrue(TeamMember.EMPTY.isEmpty());
            assertFalse(c1.isEmpty());
        }

        @Test
        @DisplayName("throw NPEs when constructors have null arguments.")
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
    }

    @Nested
    @DisplayName("for overridden methods")
    class Overrides {

        @Test
        @DisplayName("have a well-behaved equals() method.")
        void testEquals() {
            assertAll(() -> assertSame(c1, c1), () -> assertEquals(c1, c1), () -> assertEquals(c1, c2),
                    () -> assertNotEquals(c1, new Object()));

            TeamMember c3 = new TeamMember(c1);
            c3.setName("foo");
            assertNotEquals(c1, c3);

            c3 = new TeamMember(c1);
            c3.setEmail("foo");
            assertNotEquals(c1, c3);

            c3 = new TeamMember(c1);
            c3.setPhone("foo");
            assertNotEquals(c1, c3);
        }

        @DisplayName("have equal hash codes if their instances are equals().")
        @Test
        void testHashCode() {
            assertEquals(c1.hashCode(), c2.hashCode());
        }

        @DisplayName("be printable as a human-readable string.")
        @Test
        void testToString() {
            assertEquals("TeamMember [name=a, email=b, phone=c]", c1.toString());
        }
    }
}
