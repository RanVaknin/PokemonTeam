package com.example.pokemonteam;

import com.example.pokemonteam.models.Pokemon;
import com.example.pokemonteam.models.pokemon_children.Ability;
import com.example.pokemonteam.models.pokemon_children.AbilityReference;
import com.example.pokemonteam.models.pokemon_children.Move;
import com.example.pokemonteam.models.pokemon_children.MoveReference;
import com.example.pokemonteam.models.pokemon_children.PokemonTypeReference;
import com.example.pokemonteam.models.pokemon_children.Sprite;
import com.example.pokemonteam.models.pokemon_children.Type;

import java.util.ArrayList;
import java.util.List;

public class StartingPokemon {
    private List<Pokemon> starterPokemon;

    public StartingPokemon() {
        starterPokemon = new ArrayList<>();
    }

    public List<Pokemon> initializeStartingPokemon(){

        ///////////    Charizard    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> charizardTypes = new ArrayList<>();
        List<Move> charizardMoves = new ArrayList<>();
        List<Ability> charizardAbilities = new ArrayList<>();
        Sprite charizardSprite = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png");
        charizardTypes.add(new Type(new PokemonTypeReference("fire")));
        charizardTypes.add(new Type(new PokemonTypeReference("flying")));

        charizardMoves.add(new Move(new MoveReference("hyper-beam")));
        charizardMoves.add(new Move(new MoveReference("flamethrower")));
        charizardMoves.add(new Move(new MoveReference("leer")));
        charizardMoves.add(new Move(new MoveReference("double-edge")));

        charizardAbilities.add(new Ability(new AbilityReference("blaze")));
        charizardAbilities.add(new Ability(new AbilityReference("solar-power")));

        Pokemon charizard = new Pokemon("Charizard", 75,6,905,
                charizardTypes,charizardMoves,charizardAbilities,charizardSprite);

        starterPokemon.add(charizard);



        ///////////    HitmonLee    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> hitmonleeTypes = new ArrayList<>();
        List<Move> hitmonleeMoves = new ArrayList<>();
        List<Ability> hitmonleeAbilities = new ArrayList<>();
        Sprite hitmonleeSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/106.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/106.png");
        hitmonleeTypes.add(new Type(new PokemonTypeReference("fighting")));

        hitmonleeMoves.add(new Move(new MoveReference("mega-punch")));
        hitmonleeMoves.add(new Move(new MoveReference("rolling-kick")));
        hitmonleeMoves.add(new Move(new MoveReference("double-punch")));
        hitmonleeMoves.add(new Move(new MoveReference("rage")));

        hitmonleeAbilities.add(new Ability(new AbilityReference("limber")));
        hitmonleeAbilities.add(new Ability(new AbilityReference("reckless")));

        Pokemon hitmonlee = new Pokemon("Hitmonlee", 36,106,498,
                hitmonleeTypes,hitmonleeMoves,hitmonleeAbilities,hitmonleeSprites);

        starterPokemon.add(hitmonlee);


        ///////////    Raichu    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> raichuTypes = new ArrayList<>();
        List<Move> raichuMoves = new ArrayList<>();
        List<Ability> raichuAbilities = new ArrayList<>();
        Sprite raichuSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/26.png");

        raichuTypes.add(new Type(new PokemonTypeReference("electric")));

        raichuMoves.add(new Move(new MoveReference("body-slam")));
        raichuMoves.add(new Move(new MoveReference("thunderbolt")));
        raichuMoves.add(new Move(new MoveReference("shock-wave")));
        raichuMoves.add(new Move(new MoveReference("dig")));

        raichuAbilities.add(new Ability(new AbilityReference("static")));
        raichuAbilities.add(new Ability(new AbilityReference("lightning-rod")));

        Pokemon raichu = new Pokemon("Raichu", 51,26,300,
                raichuTypes,raichuMoves,raichuAbilities,raichuSprites);
        starterPokemon.add(raichu);


        ///////////    Kingler    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> kinglerTypes = new ArrayList<>();
        List<Move> kinglerMoves = new ArrayList<>();
        List<Ability> kinglerAbilities = new ArrayList<>();
        Sprite kinglerSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/99.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/99.png");

        kinglerTypes.add(new Type(new PokemonTypeReference("water")));

        kinglerMoves.add(new Move(new MoveReference("bubble-beam")));
        kinglerMoves.add(new Move(new MoveReference("metal-claw")));
        kinglerMoves.add(new Move(new MoveReference("harden")));
        kinglerMoves.add(new Move(new MoveReference("water-gun")));

        kinglerAbilities.add(new Ability(new AbilityReference("hyper-cutter")));
        kinglerAbilities.add(new Ability(new AbilityReference("shell-armor")));

        Pokemon kingler = new Pokemon("Kingler", 29,99,600,
                kinglerTypes,kinglerMoves,kinglerAbilities,kinglerSprites);

        starterPokemon.add(kingler);


        ///////////    Rhydon    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> rhydonTypes = new ArrayList<>();
        List<Move> rhydonMoves = new ArrayList<>();
        List<Ability> rhydonAbilities = new ArrayList<>();
        Sprite rhydonSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/112.png");

        rhydonTypes.add(new Type(new PokemonTypeReference("ground")));
        rhydonTypes.add(new Type(new PokemonTypeReference("rock")));


        rhydonMoves.add(new Move(new MoveReference("leer")));
        rhydonMoves.add(new Move(new MoveReference("horn-attack")));
        rhydonMoves.add(new Move(new MoveReference("roar")));
        rhydonMoves.add(new Move(new MoveReference("fire-punch")));

        rhydonAbilities.add(new Ability(new AbilityReference("reckless")));
        rhydonAbilities.add(new Ability(new AbilityReference("lightning-rod")));

        Pokemon rhydon = new Pokemon("Rhydon", 71,112,1200,
                rhydonTypes,rhydonMoves,rhydonAbilities,rhydonSprites);

        starterPokemon.add(rhydon);



        ///////////    Jigglypuff    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> jigglypuffTypes = new ArrayList<>();
        List<Move> jigglypuffMoves = new ArrayList<>();
        List<Ability> jigglypuffAbilities = new ArrayList<>();
        Sprite jigglypuffSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/39.png");

        jigglypuffTypes.add(new Type(new PokemonTypeReference("normal")));
        jigglypuffTypes.add(new Type(new PokemonTypeReference("fairy")));


        jigglypuffMoves.add(new Move(new MoveReference("leer")));
        jigglypuffMoves.add(new Move(new MoveReference("thunder-punch")));
        jigglypuffMoves.add(new Move(new MoveReference("ice-beam")));
        jigglypuffMoves.add(new Move(new MoveReference("double-edge")));

        jigglypuffAbilities.add(new Ability(new AbilityReference("competitive")));
        jigglypuffAbilities.add(new Ability(new AbilityReference("cute-charm")));

        Pokemon jigglypuff = new Pokemon("Jigglypuff", 21,39,55,
                jigglypuffTypes,jigglypuffMoves,jigglypuffAbilities,jigglypuffSprites);

        starterPokemon.add(jigglypuff);



        ///////////    Slowbro    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> slowbroTypes = new ArrayList<>();
        List<Move> slowbroMoves = new ArrayList<>();
        List<Ability> slowbroAbilities = new ArrayList<>();
        Sprite slowbroSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/80.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/80.png");

        slowbroTypes.add(new Type(new PokemonTypeReference("water")));
        slowbroTypes.add(new Type(new PokemonTypeReference("psychic")));


        slowbroMoves.add(new Move(new MoveReference("flamethrower")));
        slowbroMoves.add(new Move(new MoveReference("mega-punch")));
        slowbroMoves.add(new Move(new MoveReference("ice-beam")));
        slowbroMoves.add(new Move(new MoveReference("earthquake")));

        slowbroAbilities.add(new Ability(new AbilityReference("oblivious")));
        slowbroAbilities.add(new Ability(new AbilityReference("own-tempo")));

        Pokemon slowbro = new Pokemon("Slowbro", 44,80,785,
                slowbroTypes,slowbroMoves,slowbroAbilities,slowbroSprites);

        starterPokemon.add(slowbro);

        return starterPokemon;
    }
}
