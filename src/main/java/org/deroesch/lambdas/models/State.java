package org.deroesch.lambdas.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;

public enum State {
    PA("Pennsylvania", "PA"), CA("California", "CA"), OK("Okalhoma", "OK");

    State(@NonNull String longName, @NonNull String abbrev) {
        this.longName = longName;
        this.shortName = abbrev;
    }

    @Override
    public String toString() {
        return getLongName();
    }

    /*
     * State database
     */
    private static final Map<String, State> stateMap = new HashMap<>();

    /**
     * @return the states as a map
     */
    public static Map<String, State> getAll() {
        return Collections.unmodifiableMap(stateMap);
    }

    static {
        stateMap.put(PA.getLongName(), PA);
        stateMap.put(OK.getLongName(), OK);
        stateMap.put(CA.getLongName(), CA);
    }

    /*
     * Fields and accessors
     */
    @NonNull
    public String getLongName() {
        return longName;
    }

    @NonNull
    public String shortName() {
        return shortName;
    }

    @NonNull
    private String longName;

    @NonNull
    private String shortName;

}
