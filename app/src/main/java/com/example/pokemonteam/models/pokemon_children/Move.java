package com.example.pokemonteam.models.pokemon_children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move {

    @SerializedName("move")
    @Expose
    private MoveReference move;

    public Move(MoveReference move) {
        this.move = move;
    }

    public Move() {
    }

    public MoveReference getMove() {
        return move;
    }
}
