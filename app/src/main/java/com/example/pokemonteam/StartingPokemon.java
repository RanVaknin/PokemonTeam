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
    private ArrayList<Pokemon> starterPokemon;

    public StartingPokemon() {
        starterPokemon = new ArrayList<>();
    }

    public ArrayList<Pokemon> initializeStartingPokemon(){

        ///////////    Charizard    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> charizardTypes = new ArrayList<>();
        List<Move> charizardMoves = new ArrayList<>();
        List<Ability> charizardAbilities = new ArrayList<>();
        Sprite charizardSprite = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/6.png");
        charizardTypes.add(new Type(new PokemonTypeReference("Fire")));
        charizardTypes.add(new Type(new PokemonTypeReference("Flying")));

        charizardMoves.add(new Move(new MoveReference("Hyper-beam")));
        charizardMoves.add(new Move(new MoveReference("Flamethrower")));
        charizardMoves.add(new Move(new MoveReference("Leer")));
        charizardMoves.add(new Move(new MoveReference("Double-edge")));

        charizardAbilities.add(new Ability(new AbilityReference("Blaze")));
        charizardAbilities.add(new Ability(new AbilityReference("Solar-power")));

        Pokemon charizard = new Pokemon("Charizard", 75,6,905,
                charizardTypes,charizardMoves,charizardAbilities,charizardSprite);

        starterPokemon.add(charizard);



        ///////////    HitmonLee    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> hitmonleeTypes = new ArrayList<>();
        List<Move> hitmonleeMoves = new ArrayList<>();
        List<Ability> hitmonleeAbilities = new ArrayList<>();
        Sprite hitmonleeSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/106.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/106.png");
        hitmonleeTypes.add(new Type(new PokemonTypeReference("Fighting")));

        hitmonleeMoves.add(new Move(new MoveReference("Mega-punch")));
        hitmonleeMoves.add(new Move(new MoveReference("Rolling-kick")));
        hitmonleeMoves.add(new Move(new MoveReference("Double-punch")));
        hitmonleeMoves.add(new Move(new MoveReference("Rage")));

        hitmonleeAbilities.add(new Ability(new AbilityReference("Limber")));
        hitmonleeAbilities.add(new Ability(new AbilityReference("Reckless")));

        Pokemon hitmonlee = new Pokemon("Hitmonlee", 36,106,498,
                hitmonleeTypes,hitmonleeMoves,hitmonleeAbilities,hitmonleeSprites);

        starterPokemon.add(hitmonlee);


        ///////////    Raichu    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> raichuTypes = new ArrayList<>();
        List<Move> raichuMoves = new ArrayList<>();
        List<Ability> raichuAbilities = new ArrayList<>();
        Sprite raichuSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/26.png");

        raichuTypes.add(new Type(new PokemonTypeReference("Electric")));

        raichuMoves.add(new Move(new MoveReference("Body-slam")));
        raichuMoves.add(new Move(new MoveReference("Thunderbolt")));
        raichuMoves.add(new Move(new MoveReference("Shock-wave")));
        raichuMoves.add(new Move(new MoveReference("Dig")));

        raichuAbilities.add(new Ability(new AbilityReference("Static")));
        raichuAbilities.add(new Ability(new AbilityReference("Lightning-rod")));

        Pokemon raichu = new Pokemon("Raichu", 51,26,300,
                raichuTypes,raichuMoves,raichuAbilities,raichuSprites);
        starterPokemon.add(raichu);


        ///////////    Kingler    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> kinglerTypes = new ArrayList<>();
        List<Move> kinglerMoves = new ArrayList<>();
        List<Ability> kinglerAbilities = new ArrayList<>();
        Sprite kinglerSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/99.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/99.png");

        kinglerTypes.add(new Type(new PokemonTypeReference("Water")));

        kinglerMoves.add(new Move(new MoveReference("Bubble-beam")));
        kinglerMoves.add(new Move(new MoveReference("Metal-claw")));
        kinglerMoves.add(new Move(new MoveReference("Harden")));
        kinglerMoves.add(new Move(new MoveReference("Water-gun")));

        kinglerAbilities.add(new Ability(new AbilityReference("Hyper-cutter")));
        kinglerAbilities.add(new Ability(new AbilityReference("Shell-armor")));

        Pokemon kingler = new Pokemon("Kingler", 29,99,600,
                kinglerTypes,kinglerMoves,kinglerAbilities,kinglerSprites);

        starterPokemon.add(kingler);


        ///////////    Rhydon    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> rhydonTypes = new ArrayList<>();
        List<Move> rhydonMoves = new ArrayList<>();
        List<Ability> rhydonAbilities = new ArrayList<>();
        Sprite rhydonSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/112.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/112.png");

        rhydonTypes.add(new Type(new PokemonTypeReference("Ground")));
        rhydonTypes.add(new Type(new PokemonTypeReference("Rock")));


        rhydonMoves.add(new Move(new MoveReference("Leer")));
        rhydonMoves.add(new Move(new MoveReference("Horn-attack")));
        rhydonMoves.add(new Move(new MoveReference("Roar")));
        rhydonMoves.add(new Move(new MoveReference("Fire-punch")));

        rhydonAbilities.add(new Ability(new AbilityReference("Reckless")));
        rhydonAbilities.add(new Ability(new AbilityReference("Lightning-rod")));

        Pokemon rhydon = new Pokemon("Rhydon", 71,112,1200,
                rhydonTypes,rhydonMoves,rhydonAbilities,rhydonSprites);

        starterPokemon.add(rhydon);



        ///////////    Jigglypuff    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> jigglypuffTypes = new ArrayList<>();
        List<Move> jigglypuffMoves = new ArrayList<>();
        List<Ability> jigglypuffAbilities = new ArrayList<>();
        Sprite jigglypuffSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/39.png");

        jigglypuffTypes.add(new Type(new PokemonTypeReference("Normal")));
        jigglypuffTypes.add(new Type(new PokemonTypeReference("Fairy")));


        jigglypuffMoves.add(new Move(new MoveReference("Leer")));
        jigglypuffMoves.add(new Move(new MoveReference("Thunder-punch")));
        jigglypuffMoves.add(new Move(new MoveReference("Ice-beam")));
        jigglypuffMoves.add(new Move(new MoveReference("Double-edge")));

        jigglypuffAbilities.add(new Ability(new AbilityReference("Competitive")));
        jigglypuffAbilities.add(new Ability(new AbilityReference("Cute-charm")));

        Pokemon jigglypuff = new Pokemon("Jigglypuff", 21,39,55,
                jigglypuffTypes,jigglypuffMoves,jigglypuffAbilities,jigglypuffSprites);

        starterPokemon.add(jigglypuff);



        ///////////    Slowbro    \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        List<Type> slowbroTypes = new ArrayList<>();
        List<Move> slowbroMoves = new ArrayList<>();
        List<Ability> slowbroAbilities = new ArrayList<>();
        Sprite slowbroSprites = new Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/80.png","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/80.png");

        slowbroTypes.add(new Type(new PokemonTypeReference("Water")));
        slowbroTypes.add(new Type(new PokemonTypeReference("Psychic")));


        slowbroMoves.add(new Move(new MoveReference("Flamethrower")));
        slowbroMoves.add(new Move(new MoveReference("Mega-punch")));
        slowbroMoves.add(new Move(new MoveReference("Ice-beam")));
        slowbroMoves.add(new Move(new MoveReference("Earthquake")));

        slowbroAbilities.add(new Ability(new AbilityReference("Oblivious")));
        slowbroAbilities.add(new Ability(new AbilityReference("Own-tempo")));

        Pokemon slowbro = new Pokemon("Slowbro", 44,80,785,
                slowbroTypes,slowbroMoves,slowbroAbilities,slowbroSprites);

        starterPokemon.add(slowbro);

        return starterPokemon;
    }
}
