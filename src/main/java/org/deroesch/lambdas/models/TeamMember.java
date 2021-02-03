package org.deroesch.lambdas.models;

import java.util.Objects;

import lombok.Data;
import lombok.NonNull;

/**
 * A simple customer
 */
@Data
public class TeamMember {

    /**
     * Expected constructor
     * 
     * @param name
     * @param email
     * @param phone
     */
    public TeamMember(@NonNull String name, @NonNull String email, @NonNull String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Copy constructor
     *
     * @param c the customer to copy
     */
    public TeamMember(final TeamMember c) {
        this(c.getName(), c.getEmail(), c.getPhone());
        this.setLongevity(c.getLongevity());
        this.setSupervisor(c.getSupervisor());
    }

    @NonNull
    private String name = "";

    @NonNull
    private String email = "";

    @NonNull
    private String phone = "";

    @NonNull
    private Integer longevity = 0;

    // @Nullable
    private TeamMember supervisor = EMPTY;

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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TeamMember [name=");
        builder.append(name);
        builder.append(", email=");
        builder.append(email);
        builder.append(", phone=");
        builder.append(phone);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, phone);
    }

    public final boolean isEmpty() {
        return this.equals(EMPTY);
    }

    public static final TeamMember EMPTY = new TeamMember("", "", "");
}
