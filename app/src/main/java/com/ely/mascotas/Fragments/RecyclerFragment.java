package com.ely.mascotas.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ely.mascotas.Adapters.petAdapter;
import com.ely.mascotas.PetObject;
import com.ely.mascotas.R;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    public ArrayList<PetObject> pets;
    public RecyclerView rv_pets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_recycler, container, false);

            rv_pets = (RecyclerView) v.findViewById(R.id.rv_pets);
            rv_pets.setLayoutManager(new LinearLayoutManager(getActivity()));

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_pets.setLayoutManager(llm);
        pet_list();
        initAdapter();

        return v;
    }

    public void initAdapter(){
        petAdapter adapter = new petAdapter(pets);
        rv_pets.setAdapter(adapter);
    }
    public void pet_list(){
        pets = new ArrayList<PetObject>();

        pets.add(new PetObject("Bylly","2",(R.drawable.dog11)));
        pets.add(new PetObject("Troy","5",(R.drawable.dog12)));
        pets.add(new PetObject("Rose","3",(R.drawable.dog13)));
        pets.add(new PetObject("Miky","4",(R.drawable.dog14)));
        pets.add(new PetObject("froy","3",(R.drawable.dog15)));
    }

}