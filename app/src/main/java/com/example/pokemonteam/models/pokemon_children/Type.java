package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type {
    @SerializedName("slot")
    @Expose
    private int slot;

    @SerializedName("type")
    @Expose
    private PokemonTypeReference type;


    public Type(int slot, PokemonTypeReference type) {
        this.slot = slot;
        this.type = type;
    }

    public Type() {
    }

    public Type(PokemonTypeReference type) {
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public PokemonTypeReference getType() {
        return type;
    }
}
