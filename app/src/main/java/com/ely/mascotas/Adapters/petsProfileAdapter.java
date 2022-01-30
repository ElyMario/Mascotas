package com.ely.mascotas.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ely.mascotas.PetObject;
import com.ely.mascotas.R;

import java.util.ArrayList;

public class petsProfileAdapter extends RecyclerView.Adapter<petsProfileAdapter.petsProfileAdapterViewHolder> {

   public petsProfileAdapter(ArrayList<PetObject> PetList){
       this.PetList = PetList;
   }
    ArrayList<PetObject> PetList;
    Context CurrentContext;

    @NonNull
    @Override
    public petsProfileAdapter.petsProfileAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card_profile, null, false);
        CurrentContext = parent.getContext();

        return new petsProfileAdapter.petsProfileAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull petsProfileAdapter.petsProfileAdapterViewHolder holder, int position) {
        holder.img_pet.setImageResource(PetList.get(position).getImage());

        holder.tv_rating.setText(PetList.get(position).getLikes());
    }

    @Override
    public int getItemCount() {
        return PetList.size();
    }

    public class petsProfileAdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView img_pet;
        ImageView imv_rating;

        TextView tv_rating;
        int likes = 0;

        public petsProfileAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            img_pet = (ImageView) itemView.findViewById(R.id.img_pet);
            imv_rating = (ImageView) itemView.findViewById(R.id.imv_rating);

            tv_rating = (TextView) itemView.findViewById(R.id.tv_rating);
        }
    }
}
