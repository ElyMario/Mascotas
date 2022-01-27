package com.ely.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ely.mascotas.Adapters.favoritesAdapter;

import java.util.ArrayList;

public class Favorites extends AppCompatActivity {

    public ArrayList<PetObject> pets;
    public RecyclerView rv_petsf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);

        rv_petsf = (RecyclerView) findViewById(R.id.rv_petsf);
        rv_petsf.setLayoutManager(new LinearLayoutManager(this));

/*        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_pets.setLayoutManager(llm);*/
        pet_list();
        initAdapter();

    }

    public void initAdapter() {
        favoritesAdapter adapter = new favoritesAdapter(pets);
        rv_petsf.setAdapter(adapter);
    }

    public void pet_list() {
        pets = new ArrayList<PetObject>();

        pets.add(new PetObject("Bylly", "2", (R.drawable.dog11)));
        pets.add(new PetObject("Troy", "5", (R.drawable.dog12)));
        pets.add(new PetObject("Rose", "3", (R.drawable.dog13)));
        pets.add(new PetObject("Miky", "4", (R.drawable.dog14)));
        pets.add(new PetObject("froy", "3", (R.drawable.dog15)));
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(Favorites.this, Favorites.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}