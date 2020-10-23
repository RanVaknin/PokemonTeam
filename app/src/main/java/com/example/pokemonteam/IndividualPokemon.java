package com.example.pokemonteam;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.pokemonteam.models.Pokemon;
import com.example.pokemonteam.models.pokemon_children.Ability;
import com.example.pokemonteam.models.pokemon_children.Type;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndividualPokemon extends AppCompatActivity {
    TextView pokemonTitle;
    TextView pokemonName;
    TextView pokemonId;
    TextView pokemonWeight;
    TextView pokemonHeight;
    TextView pokemonTypes;
    TextView pokemonMoves;
    TextView pokemonAbilities;

    ImageView scrollBack;
    ImageView scrollFront;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_individual_pokemon2);

        // removing the title from this activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(" ");

        // getting the pokemon object from the MainActivity
        Pokemon pokemon = getIntent().getParcelableExtra("pokemon");

        // grabbing all the views by ID and assigning them to our fields.
        pokemonMoves = findViewById(R.id.scrollerMoves);
        pokemonAbilities = findViewById(R.id.scrollerAbilities);
        scrollBack = findViewById(R.id.scrollBack);
        scrollFront = findViewById(R.id.scrollFront);
        pokemonTitle = findViewById(R.id.scrollerTitle);
        pokemonName = findViewById(R.id.scrollerName);
        pokemonId = findViewById(R.id.scrollerid);
        pokemonWeight = findViewById(R.id.scrollerWeight);
        pokemonHeight = findViewById(R.id.scrollerHeight);
        pokemonTypes = findViewById(R.id.scrollerTypes);
        ArrayList<Pokemon> team = new ArrayList<>();
        subscribePokemon(pokemon.getId(),team);


    }

    //this function sets up the retrofit request based on the Pokemon endpoint and the Move endpoint
    @SuppressLint("CheckResult") // linter is annoying
    public void subscribePokemon(int clickedPokemon, ArrayList<Pokemon> pokemonList) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                //using GSON to parse the JSON to an object
                .addConverterFactory(GsonConverterFactory.create())
                //using Rx to get results Async
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //initializing the APIs we created using retrofit
        PokemonApi api = retrofit.create(PokemonApi.class);
        MoveApi moveApi = retrofit.create(MoveApi.class);
        // creating a factory of integers representing the pokemon id - operating on each id at a time (in this case only once)
        Observable.fromIterable(Arrays.asList(clickedPokemon))
                //flattening out the Observable to get a concrete pokemon ID and making the request to the API with that id getting back a pokemon
                .flatMap(pokemonId -> api.getPokemon(pokemonId)
                        //getting an Observable from the API we flatten it again to receive a concrete Pokemon and use it to create another factory of Moves
                        .flatMap(pokemon -> Observable.fromIterable(pokemon.getMoves())
                                // with that we make an API call and get an Observable<MoveExtended>
                                .flatMap(moveSlot -> moveApi.getMove(moveSlot.getMove().getName()))
                                // Iterate over each move and assign it a pair with our pokemon and the move (I use this custom Pair class to not lose reference to the pokemon we get back)
                                .map(move -> new Pair(pokemon,move))))
                // subscrive on back thread
                .subscribeOn(Schedulers.io())
                // observe on main thread
                .observeOn(AndroidSchedulers.mainThread())
                // subscribe to the changes and reassign variables
                .subscribe(result -> {

                    // in order not to overwrite photos and data for each move I created an if statement to ensure the only data that will be overwritten are the moves.
                    pokemonList.add(result.getPokemon());
                    if(scrollFront.getTag().equals("front")){
                        setBackground((ArrayList<Type>) result.getPokemon().getTypes());
                        pokemonTitle.setText(Formatter.capitalizeFirst(result.getPokemon().getName()));
                        pokemonName.append("" +Formatter.capitalizeFirst(result.getPokemon().getName()));
                        pokemonId.append("" +result.getPokemon().getId());
                        pokemonWeight.append("" +result.getPokemon().getWeight());
                        pokemonHeight.append(""+result.getPokemon().getHeight());
                        pokemonTypes.append(""+ Formatter.capitalizeFirst(result.getPokemon().getTypes().get(0).getType().getName()));
                        if(result.getPokemon().getTypes().size() > 1){
                            pokemonTypes.setText("Types: " + Formatter.capitalizeFirst(result.getPokemon().getTypes().get(0).getType().getName()) +", " + Formatter.capitalizeFirst(result.getPokemon().getTypes().get(1).getType().getName()));
                        }
                        for(Ability ab : result.getPokemon().getAbilities()){
                            pokemonAbilities.append("\n  ∙ " + Formatter.capitalizeFirst(ab.getAbility().getName()));
                        }

                        Picasso.get().load(result.getPokemon().getSprite().getBackImg()).into(scrollBack);
                        Picasso.get().load(result.getPokemon().getSprite().getFrontImg()).into(scrollFront);
                        scrollFront.setTag("");



                    }
                    String effect = result.getMove().getEffect_entries().get(0).getEffect();

                    // removing annoying and  redundant $effect_chance from the string
                    String newStr = "a";
                    if(effect.contains("$effect_chance%")){
                        newStr = Formatter.removePart(effect);
                        pokemonMoves.append("\n∙ " + Formatter.capitalizeFirst(result.getMove().getName()) + ": " + Formatter.capitalizeFirst(newStr));

                    } else {
                        pokemonMoves.append("\n∙ " + Formatter.capitalizeFirst(result.getMove().getName()) + ": " + Formatter.capitalizeFirst(effect));
                    }

                });

    }


    // just a nifty flair, based on the pokemon type, I uploaded corresponding backgrounds to each pokemon
    public void setBackground(ArrayList<Type> type){
        String mainType;
        mainType = type.get(0).getType().getName();
        View v = findViewById(R.id.app_bar);

        switch(mainType) {
            case "water":
                v.setBackgroundResource(R.drawable.water);
                break;

            case "normal":
                v.setBackgroundResource(R.drawable.normal);
                break;

            case "grass":
                v.setBackgroundResource(R.drawable.grasstype);
                break;

            case "poison":
            case "bug":
                v.setBackgroundResource(R.drawable.bug);
                break;

            case "fighting":
            case "ground":
            case "rock":

            case "steel":
                v.setBackgroundResource(R.drawable.rock);
                break;

            case "dark":
                v.setBackgroundResource(R.drawable.dark);
                break;

            case "ghost":
                v.setBackgroundResource(R.drawable.ghost);
                break;

            case "electric":
                v.setBackgroundResource(R.drawable.electric);
                break;

            case "flying":
            case "dragon":
            case "fire":
                v.setBackgroundResource(R.drawable.fire);
                break;

            case "ice":
                v.setBackgroundResource(R.drawable.ice);
                break;

            case "psychic":
                v.setBackgroundResource(R.drawable.psychic);
                break;

            default:
                v.setBackgroundResource(R.drawable.normal);
                break;
        }
    }

}