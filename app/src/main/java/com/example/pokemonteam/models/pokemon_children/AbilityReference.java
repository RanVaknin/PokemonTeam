package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbilityReference {
    @SerializedName("name")
    @Expose
    private String name;

    public AbilityReference(String name) {
        this.name = name;
    }

    public AbilityReference() {
    }

    public String getName() {
        return name;
    }
}
