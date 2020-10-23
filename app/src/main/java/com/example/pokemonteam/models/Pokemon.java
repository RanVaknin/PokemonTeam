package com.example.pokemonteam.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.pokemonteam.models.pokemon_children.Ability;
import com.example.pokemonteam.models.pokemon_children.Move;
import com.example.pokemonteam.models.pokemon_children.Sprite;
import com.example.pokemonteam.models.pokemon_children.Type;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// I used Parcelable just to pass in the Pokemon object in the extra of the Intent between Main -> IndividualPokemon activities.

public class Pokemon implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("level")
    @Expose
    private int level;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("weight")
    @Expose
    private int weight;

    @SerializedName("height")
    @Expose
    private int height;

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

    // empty constructor for GSON to use.
    private Pokemon() {
    }

    public Pokemon(String name, int level, int pokemonId, int weight, Sprite sprite, int height) {
        this.name = name;
        this.level = generatePokemonLevel();
        this.id = pokemonId;
        this.weight = weight;
        this.height = height;
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.sprite = sprite;
    }
    public Pokemon(String name, int level, int pokemonId, int weight,List<Type> types, List<Move> moves, List<Ability> abilities, Sprite sprite) {
        this.name = name;
        this.level = level;
        this.id = pokemonId;
        this.weight = weight;
        this.types = types;
        this.abilities = abilities;
        this.sprite = sprite;
        this.moves = moves;
    }

    protected Pokemon(Parcel in) {
        name = in.readString();
        level = in.readInt();
        id = in.readInt();
        weight = in.readInt();
        height = in.readInt();
        Description = in.readString();

    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
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

    public int getHeight() {
        return height;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(level);
        dest.writeInt(id);
        dest.writeInt(weight);
        dest.writeInt(height);
        dest.writeString(Description);
    }

    public void setLevel() {
        this.level = generatePokemonLevel();
    }
}
