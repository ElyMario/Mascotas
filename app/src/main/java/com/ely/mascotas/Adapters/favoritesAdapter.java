package com.ely.mascotas.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ely.mascotas.PetObject;
import com.ely.mascotas.R;

import java.util.ArrayList;

public class favoritesAdapter extends RecyclerView.Adapter<favoritesAdapter.favoritesAdapterViewHolder> {

    public favoritesAdapter(ArrayList<PetObject> PetList){
        this.PetList = PetList;
    }
    ArrayList<PetObject> PetList;
    Context CurrentContext;

    @NonNull
    @Override
    public favoritesAdapter.favoritesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_favorites_card, null, false);
        CurrentContext = parent.getContext();
        return new favoritesAdapter.favoritesAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull favoritesAdapter.favoritesAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.img_pet.setImageResource(PetList.get(position).getImage());
        holder.name_pet.setText(PetList.get(position).getName());
        holder.tv_rating.setText(PetList.get(position).getLikes());

    }

    @Override
    public int getItemCount() {
         return PetList.size();
    }

    public class favoritesAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView img_pet;
        ImageView imv_rating;
        TextView name_pet;
        TextView tv_rating;
        int likes = 0;

        public favoritesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            img_pet = (ImageView) itemView.findViewById(R.id.img_pet);
            imv_rating = (ImageView) itemView.findViewById(R.id.imv_rating);
            name_pet = (TextView) itemView.findViewById(R.id.name_pet);
            tv_rating = (TextView) itemView.findViewById(R.id.tv_rating);
        }
    }
}
