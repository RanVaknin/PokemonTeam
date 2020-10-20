package com.example.pokemonteam;

import com.example.pokemonteam.models.MoveExtended;
import com.example.pokemonteam.models.Pokemon;

public class Pair {
    private Pokemon pokemon;
    private MoveExtended move;


    public Pair(Pokemon pokemon, MoveExtended move) {
        this.pokemon = pokemon;
        this.move = move;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public MoveExtended getMove() {
        return move;
    }
}
