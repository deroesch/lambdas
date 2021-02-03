package org.deroesch.lambdas.models;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * A simple customer
 */
@Data
@AllArgsConstructor
public class TeamMember {

    /**
     * Copy constructor
     *
     * @param c the customer to copy
     */
    public TeamMember(final TeamMember c) {
        name = c.name;
        email = c.email;
        phone = c.phone;
    }

    @NonNull
    private String name = "";

    @NonNull
    private String email = "";

    @NonNull
    private String phone = "";

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeamMember)) {
            return false;
        }
        final TeamMember other = (TeamMember) obj;
        return Objects.equals(email, other.email) && Objects.equals(name, other.name)
                && Objects.equals(phone, other.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, phone);
    }
}
