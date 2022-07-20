package com.example.themaplreable.model.enums;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * Enumeration containing the possible values for the position attribute of a player.
 */
public enum Type {
    @JsonAlias("amber")
    AMBER,

    @JsonAlias("dark")
    DARK,

    @JsonAlias("clear")
    CLEAR
}
