package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonTypeReference {
    @SerializedName("name")
    @Expose
    private String name;

    public PokemonTypeReference(String name) {
        this.name = name;
    }

    public PokemonTypeReference() {
    }

    public String getName() {
        return name;
    }
}
