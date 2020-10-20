package com.example.pokemonteam;

import com.example.pokemonteam.models.Pokemon;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface PokemonApi {
    @Headers("Content-Type: application/json")
    @GET("pokemon/{id}")
    Observable<Pokemon> getPokemon(@Path("id") int id);


}
