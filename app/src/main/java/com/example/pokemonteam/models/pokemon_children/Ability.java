package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ability {

    @SerializedName("ability")
    @Expose
    private AbilityReference ability;


    public Ability(AbilityReference ability) {
        this.ability = ability;
    }

    public Ability() {
    }

    public AbilityReference getAbility() {
        return ability;
    }
}
