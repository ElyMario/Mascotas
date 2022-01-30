package com.ely.mascotas.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ely.mascotas.Adapters.favoritesAdapter;
import com.ely.mascotas.Adapters.petsProfileAdapter;
import com.ely.mascotas.PetObject;
import com.ely.mascotas.R;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    public ArrayList<PetObject> pets;
    public RecyclerView rv_petsf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_perfil, container, false);


        rv_petsf = (RecyclerView) v.findViewById(R.id.rv_petsf);
      //  rv_petsf.setLayoutManager(new LinearLayoutManager(getActivity()));

        GridLayoutManager llm = new GridLayoutManager(getActivity(), 4);
      //  llm.setOrientation(GridLayoutManager.VERTICAL);
        rv_petsf.setLayoutManager(llm);
        pet_list();
        initAdapter();

        return v;

    }

    public void initAdapter() {
        petsProfileAdapter adapter = new petsProfileAdapter(pets);
        rv_petsf.setAdapter(adapter);
    }

    public void pet_list() {
        pets = new ArrayList<PetObject>();

        pets.add(new PetObject("Bylly", "2", (R.drawable.dog12)));
        pets.add(new PetObject("Troy", "5", (R.drawable.dog12)));
        pets.add(new PetObject("Rose", "3", (R.drawable.dog12)));
        pets.add(new PetObject("Miky", "4", (R.drawable.dog12)));
        pets.add(new PetObject("froy", "3", (R.drawable.dog12)));
        pets.add(new PetObject("Bylly", "2", (R.drawable.dog12)));
        pets.add(new PetObject("Troy", "5", (R.drawable.dog12)));
        pets.add(new PetObject("Rose", "3", (R.drawable.dog12)));
        pets.add(new PetObject("Miky", "4", (R.drawable.dog12)));
        pets.add(new PetObject("froy", "3", (R.drawable.dog12)));
    }

}

