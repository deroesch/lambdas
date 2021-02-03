package org.deroesch.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.deroesch.lambdas.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class CustomerTest {

    Customer c1;
    Customer c2;
    private static final Class<NullPointerException> NPE = NullPointerException.class;

    @BeforeEach
    void beforeEach() {
        c1 = new Customer("a", "b", "c");
        c2 = new Customer(c1);
    }

    @Test
    void testCreated() {
        assertNotNull(c1);
        assertNotNull(c2);
    }

    @Test
    void testConstructor() {
        assertThrows(NPE, () -> {
            new Customer(null, "", "");
        });

        assertThrows(NPE, () -> {
            new Customer("", null, "");
        });

        assertThrows(NPE, () -> {
            new Customer("", "", null);
        });
    }

    @Test
    void testEquals() {
        assertSame(c1, c1);
        assertEquals(c1, c1);
        assertEquals(c1, c2);
        assertNotEquals(c1, new Object());

        Customer c3 = new Customer(c1);
        c3.setName("foo");
        assertNotEquals(c1, c3);

        c3 = new Customer(c1);
        c3.setEmail("foo");
        assertNotEquals(c1, c3);

        c3 = new Customer(c1);
        c3.setPhone("foo");
        assertNotEquals(c1, c3);

        final Customer c4 = new Customer(c1);
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
        assertEquals("Customer(name=a, email=b, phone=c)", c1.toString());
    }
}
