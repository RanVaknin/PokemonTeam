package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoveReference {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    public MoveReference(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public MoveReference() {
    }

    public MoveReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
