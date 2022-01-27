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
import android.widget.ListView;

import com.ely.mascotas.Adapters.petAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<PetObject> pets;
    public RecyclerView rv_pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);

        rv_pets = (RecyclerView) findViewById(R.id.rv_pets);
        rv_pets.setLayoutManager(new LinearLayoutManager(this));

/*        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_pets.setLayoutManager(llm);*/
        pet_list();
        initAdapter();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, Favorites.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}