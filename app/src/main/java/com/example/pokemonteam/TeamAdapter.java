package com.example.pokemonteam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonteam.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> implements Filterable {
    private ArrayList<Pokemon> pokemonTeam;
    private ArrayList<Pokemon> pokemonTeamFull;

    public static class TeamViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView pokemonName;
        public TextView pokemonLevel;
        public TextView pokemonType;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.pokemonListImg);
            pokemonName = itemView.findViewById(R.id.pokemonListName);
            pokemonLevel = itemView.findViewById(R.id.pokemonListLvl);
            pokemonType = itemView.findViewById(R.id.pokemonListType);

        }
    }

    public TeamAdapter(ArrayList<Pokemon> pokemonList) {
        pokemonTeam = pokemonList;
        pokemonTeamFull = new ArrayList<>(pokemonTeam);
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_line,parent,false);
        TeamViewHolder tvh = new TeamViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Pokemon current = pokemonTeam.get(position);
        Picasso.get().load(current.getSprite().getFrontImg()).into(holder.mImageView);
        holder.pokemonName.append(" " + current.getName());
        holder.pokemonLevel.setText("Level " + current.getLevel());
        String type1 = current.getTypes().get(0).getType().getName();
        String type2 = "";
        if(current.getTypes().size() > 1){
            type2 = ", " + current.getTypes().get(1).getType().getName();
        }
        holder.pokemonType.append(" " + type1 + type2);
    }

    @Override
    public int getItemCount() {
        return pokemonTeam.size();
    }

    @Override
    public Filter getFilter() {
        return teamFilter;
    }
    private Filter teamFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Pokemon> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(pokemonTeamFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Pokemon pokemon : pokemonTeamFull){
                    if(pokemon.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(pokemon);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            pokemonTeam.clear();
            pokemonTeam.addAll((List) results.values);
        }
    };


}


