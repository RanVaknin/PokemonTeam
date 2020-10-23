package com.example.pokemonteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.pokemonteam.models.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TeamAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean beacon = true;
    private NotificationManagerCompat notificationManager;

    private List<Pokemon> pokemonTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting up notification manager
        notificationManager = NotificationManagerCompat.from(this);
        // setting up custom toolbar with hamburger menu as icon.
        setSupportActionBar(findViewById(R.id.myToolbar));
        Toolbar toolbar = findViewById(R.id.myToolbar);
        Drawable myIcon = getResources().getDrawable(R.drawable.ic_round_dehaze_24,getTheme());
        toolbar.setOverflowIcon(myIcon);


        pokemonTeam = new ArrayList<>();
        StartingPokemon startingPokemon = new StartingPokemon();
        // initialize hardcoded team of pokemon
        ArrayList<Pokemon> initialTeam = startingPokemon.initializeStartingPokemon();
        //setting up the recyclerView and feeding it the hardcoded team.
        setRecyclerView(initialTeam);




    }

    // this function is in charge of capturing which menu item the user clicked on (generate team or beacon enable/disable)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // clearing the current team so we wont keep adding onto our team
        pokemonTeam.clear();
        switch (item.getItemId()){
            case R.id.generateTeam:
                //sending the notification
                sendOnChannelOne();
                //specifying we want a team of 7 Pokemons
                getRandomTeam(7)
                        //subscribing on a background thread
                        .subscribeOn(Schedulers.io())
                        //observing changes on the main thread
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(result -> {
                            result.setLevel();
                            pokemonTeam.add(result);
                            //setting the recyclerView AGAIN with the new randomly generated team.
                            setRecyclerView(pokemonTeam);
                        });

                //this is a simple on / off toggle - toggling between Enable and Disable
            case R.id.beacon:
                String beaconText;
                if(beacon){
                    beacon = false;
                    beaconText = "Enabled";
                } else {
                    beacon = true;
                    beaconText = "Disabled";

                }
                Toast.makeText(getApplicationContext(),beaconText,Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

    //inflating the menu with the search bar we created to override the default one.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pokemon_menu,menu);

        MenuItem item = menu.findItem(R.id.searchBar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //showing the changes using the filter method we created for the adapter
            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }

        });
        return true;
    }

    //simply setting the recyclerview with a list of Pokemon
    private void setRecyclerView(List<Pokemon> team){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new TeamAdapter(team);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        //making a recyclerview individual line clickable and passing pokemon as an extra to the indiivudalPokemon activity.
        mAdapter.setOnItemClickListener(new TeamAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Pokemon pokemon = team.get(position);
                Intent i = new Intent(getBaseContext(), IndividualPokemon.class);
                i.putExtra("pokemon",pokemon);
                startActivity(i);
            }
        });
    }

    // making a async retrofit call using RxJava, returning the fatory Observable<pokemon> so we can later subscribe to it when the "generate pokemon team" button is pressed
    private Observable<Pokemon> getRandomTeam(int count){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            PokemonApi api = retrofit.create(PokemonApi.class);

        return Observable.fromIterable(new Random().ints(1,152).distinct().limit(count)::iterator)
            .flatMap(pokemonId -> api.getPokemon(pokemonId));
    }

    // function call building the notification and activating it.
    public void sendOnChannelOne(){
        Notification n = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_sharp_sentiment_very_satisfied_24)
                .setContentTitle("Hello Pokemon")
                .setContentText("Pokedex says hello!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1,n);
    }

}