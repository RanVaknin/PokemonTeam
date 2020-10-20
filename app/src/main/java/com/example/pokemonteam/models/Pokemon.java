package com.example.pokemonteam.models;

import com.example.pokemonteam.models.pokemon_children.Ability;
import com.example.pokemonteam.models.pokemon_children.Move;
import com.example.pokemonteam.models.pokemon_children.Sprite;
import com.example.pokemonteam.models.pokemon_children.Type;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("level")
    @Expose
    private int level;

    @SerializedName("id")
    @Expose
    private int pokemonId;

    @SerializedName("weight")
    @Expose
    private int weight;

    @SerializedName("types")
    @Expose
    private List<Type> types;
//
    @SerializedName("moves")
    @Expose
    private List<Move> moves;

    private String Description;

    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities;

    @SerializedName("sprites")
    @Expose
    private Sprite sprite;

    public List<MoveExtended> fullMoves;

    private Pokemon() {
    }

    public Pokemon(String name, int level, int pokemonId, int weight, Sprite sprite) {
        this.name = name;
        this.level = generatePokemonLevel();
        this.pokemonId = pokemonId;
        this.weight = weight;
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.sprite = sprite;
    }
    public Pokemon(String name, int level, int pokemonId, int weight,List<Type> types, List<Move> moves, List<Ability> abilities, Sprite sprite) {
        this.name = name;
        this.level = generatePokemonLevel();
        this.pokemonId = pokemonId;
        this.weight = weight;
        this.types = types;
        this.abilities = abilities;
        this.sprite = sprite;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public int getWeight() {
        return weight;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }


    public List<Type> getTypes() {
        return types;
    }

    private int generatePokemonLevel(){
        Random rnd = new Random();
        int num = 1 + rnd.nextInt(99);
        return num;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
