package com.ely.mascotas.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class petAdapter extends RecyclerView.Adapter<petAdapter.PetAdapterViewHolder> {


    ArrayList<PetObject> PetList;
    Context CurrentContext;

    public petAdapter(ArrayList<PetObject> PetList){
        this.PetList = PetList;
    }



    @NonNull
    @Override
    public PetAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card, null, false);
        CurrentContext = parent.getContext();
        return new petAdapter.PetAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapterViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.img_pet.setImageResource(PetList.get(position).getImage());
        holder.name_pet.setText(PetList.get(position).getName());
        holder.tv_rating.setText(PetList.get(position).getLikes());
        holder.imv_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String likes = PetList.get(position).getName();
                Toast.makeText(CurrentContext, "Diste like a " + likes, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return PetList.size();
    }


    public static class PetAdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView img_pet;
        ImageView imv_rating;
        TextView name_pet;
        TextView tv_rating;
        int likes = 0;


        public PetAdapterViewHolder( View itemView) {
            super(itemView);
            img_pet = (ImageView) itemView.findViewById(R.id.img_pet);
            imv_rating = (ImageView) itemView.findViewById(R.id.imv_rating);
            name_pet = (TextView) itemView.findViewById(R.id.name_pet);
            tv_rating = (TextView) itemView.findViewById(R.id.tv_rating);
        }
    }
}
