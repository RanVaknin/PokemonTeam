package com.example.pokemonteam.models;

import com.example.pokemonteam.models.move_children.Description;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoveExtended {


    private String name;
    @SerializedName("effect_entries")
    @Expose
    private List<Description> effect_entries;

    public MoveExtended(List<Description> effect_entries) {
        this.effect_entries = effect_entries;
    }

    public MoveExtended() {
    }


    public List<Description> getEffect_entries() {
        return effect_entries;
    }

    public String getName() {
        return name;
    }
}
