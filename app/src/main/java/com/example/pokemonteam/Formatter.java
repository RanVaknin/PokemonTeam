package com.example.pokemonteam;

public class Formatter {

    public static String capitalizeFirst(String str){
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
        return cap;
    }

    public static String removePart(String str){
        String replaced = str.replace(" $effect_chance%", "");
        return replaced;
    }

}
