package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sprite {
    @SerializedName("front_default")
    @Expose
    private String frontImg;
    @SerializedName("back_default")
    @Expose
    private String backImg;

    public Sprite(String frontImg, String backImg) {
        this.frontImg = frontImg;
        this.backImg = backImg;
    }

    public Sprite() {
    }

    public String getFrontImg() {
        return frontImg;
    }

    public String getBackImg() {
        return backImg;
    }
}
