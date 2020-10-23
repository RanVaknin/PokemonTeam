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
import java.util.Collection;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> implements Filterable {
    private List<Pokemon> pokemonTeam;
    private List<Pokemon> pokemonTeamFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    // view holder inner class
    public static class TeamViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView pokemonName;
        public TextView pokemonLevel;
        public TextView pokemonType;

        // view holder constructor
        public TeamViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.pokemonListImg);
            pokemonName = itemView.findViewById(R.id.pokemonListName);
            pokemonLevel = itemView.findViewById(R.id.pokemonListLvl);
            pokemonType = itemView.findViewById(R.id.pokemonListType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position =  getBindingAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    //adapter constructor
    public TeamAdapter(List<Pokemon> pokemonList) {
        pokemonTeam = pokemonList;
        pokemonTeamFull = new ArrayList<>(pokemonTeam);

    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_line,parent,false);
        return new TeamViewHolder(v,mListener);
    }

    // populating each row of the recyclerview based on which position we are in the pokemon list.
    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Pokemon current = pokemonTeam.get(position);
        Picasso.get().load(current.getSprite().getFrontImg()).into(holder.mImageView);
        holder.pokemonName.setText("Name: " + Formatter.capitalizeFirst(current.getName()));
        holder.pokemonLevel.setText("Level " + current.getLevel());
        String type1 = Formatter.capitalizeFirst(current.getTypes().get(0).getType().getName());
        String type2 = "";
        if(current.getTypes().size() > 1){
            type2 = ", " + Formatter.capitalizeFirst(current.getTypes().get(1).getType().getName());
        }
        holder.pokemonType.setText("Types: " + type1 + type2);
    }

    @Override
    public int getItemCount() {
        return pokemonTeam.size();
    }

    @Override
    public Filter getFilter() {
        return teamFilter;
    }

    // filtering method for the search bar.
    private Filter teamFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create an empty list
            List<Pokemon> filteredList = new ArrayList<>();
            // If the user didnt write anything in the searchbar just display the full list.
            if (constraint.toString().toLowerCase().isEmpty()) {
                filteredList.addAll(pokemonTeamFull);

            // Otherwise iterate over the original list of displayed pokemon and see if what the user put in the seach bar exists within any pokemon's name, and if so add them to the new list.
            } else {
                for (Pokemon pokemon : pokemonTeamFull) {
                    if (pokemon.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(pokemon);
                    }
                }
            }
            // Return the values from the filtered list
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;

        }

        // Funciton that takes in our filtered results and the search query and updates the UI with the new values based on the search criteria.
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            pokemonTeam.clear();
            pokemonTeam.addAll((Collection<? extends Pokemon>) results.values);

            notifyDataSetChanged();
        }

    };







}


