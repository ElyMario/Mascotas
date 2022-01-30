package com.ely.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.ely.mascotas.Adapters.PageAdapter;
import com.ely.mascotas.Adapters.petAdapter;
import com.ely.mascotas.Fragments.PerfilFragment;
import com.ely.mascotas.Fragments.RecyclerFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

       Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);

/*        if(toolbar != null){
            setSupportActionBar(toolbar);
        }*/

    }

    /**
     *
     * Esto es la implementacion del viewpager con fragment y recyclerview
     * 28/01/2022
     */
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    @SuppressLint("ResourceAsColor")
    public void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_hand_star_48);
        tabLayout.setTabIconTint(ColorStateList.valueOf(R.color.color_on_primary));
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_dog_paw_30);

    }


    /**
     * con onCreateOptionsMenu llamamos el menu para que aparesca en la Toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * con onOptionsItemSelected le damos las funciones a cada elemento por el id en el menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, Favorites.class);
                startActivity(intent);
                return true;

            case R.id.Contacto:
                Intent i = new Intent(MainActivity.this, Contact.class);
                startActivity(i);
                break;
                case R.id.About:
                Intent about = new Intent(MainActivity.this, About.class);
                startActivity(about);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}