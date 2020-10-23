package com.example.pokemonteam.models.pokemon_children;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type implements Parcelable {
    @SerializedName("slot")
    @Expose
    private int slot;

    @SerializedName("type")
    @Expose
    private PokemonTypeReference type;


    public Type(int slot, PokemonTypeReference type) {
        this.slot = slot;
        this.type = type;
    }

    public Type() {
    }

    public Type(PokemonTypeReference type) {
        this.type = type;
    }

    protected Type(Parcel in) {
        slot = in.readInt();
    }

    public static final Creator<Type> CREATOR = new Creator<Type>() {
        @Override
        public Type createFromParcel(Parcel in) {
            return new Type(in);
        }

        @Override
        public Type[] newArray(int size) {
            return new Type[size];
        }
    };

    public int getSlot() {
        return slot;
    }

    public PokemonTypeReference getType() {
        return type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(slot);
    }
}
