package com.example.pokemonteam;

import com.example.pokemonteam.models.MoveExtended;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoveApi {
    @GET("move/{move}")
    Observable<MoveExtended> getMove(@Path("move") String move);
}
