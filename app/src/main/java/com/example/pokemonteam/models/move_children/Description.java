package com.example.pokemonteam.models.move_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("short_effect")
    @Expose
    private String short_effect;

    public Description(String short_effect) {
        this.short_effect = short_effect;
    }

    public Description() {
    }

    public String getEffect() {
        return short_effect;
    }
}
