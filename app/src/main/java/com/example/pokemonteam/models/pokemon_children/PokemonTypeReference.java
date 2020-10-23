package com.example.pokemonteam.models.pokemon_children;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonTypeReference implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;

    public PokemonTypeReference(String name) {
        this.name = name;
    }

    public PokemonTypeReference() {
    }

    protected PokemonTypeReference(Parcel in) {
        name = in.readString();
    }

    public static final Creator<PokemonTypeReference> CREATOR = new Creator<PokemonTypeReference>() {
        @Override
        public PokemonTypeReference createFromParcel(Parcel in) {
            return new PokemonTypeReference(in);
        }

        @Override
        public PokemonTypeReference[] newArray(int size) {
            return new PokemonTypeReference[size];
        }
    };

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
