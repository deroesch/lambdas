package org.deroesch.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.deroesch.lambdas.models.TeamMember;
import org.eclipse.jdt.annotation.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("An App should ")
class AppTest {

    private static final @NonNull
    App APP = new App();

    @Test
    @DisplayName("have a callable main() method.")
    void testMain() {
        final String[] args = {};
        APP.main(args);
    }

    @Test
    @DisplayName("have a good customer list.")
    void testGetCustomers() {
        final List<TeamMember> customers = APP.getCustomers();

        assertEquals(3, customers.size());
        assertTrue(customers.contains(APP.alice));
        assertTrue(customers.contains(APP.bob));
        assertTrue(customers.contains(APP.charlie));
        assertFalse(customers.contains(APP.dan));
    }

}
