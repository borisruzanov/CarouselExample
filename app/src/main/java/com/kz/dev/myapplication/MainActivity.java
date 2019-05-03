package com.kz.dev.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HotAdapter.ItemClickListener,NavigationView.OnNavigationItemSelectedListener {

    private HotAdapter adapter;
    Toolbar toolbar;

    //TODO НЕ ЗАБЫТЬ Style + Manifest изменения
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

//        ((MainActivity)getActivity()).searchButtonHide(false);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new HotAdapter(this, getList());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }



    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on item position " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.drawer_top_menu_first_item:
                Log.d("test", "clicked");
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private List<Integer> getList() {
        // data to populate the RecyclerView with
        ArrayList<Integer> viewColors = new ArrayList<>();
        viewColors.add(R.drawable.photo_4);
        viewColors.add(R.drawable.photo_5);
        viewColors.add(R.drawable.photo_9);
        viewColors.add(R.drawable.photo_11);
        viewColors.add(R.drawable.photo_19);
        viewColors.add(R.drawable.photo_21);
        viewColors.add(R.drawable.photo_27);
        viewColors.add(R.drawable.photo_30);
        viewColors.add(R.drawable.photo_39);
        viewColors.add(R.drawable.photo_40);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        viewColors.add(R.drawable.photo);
        return viewColors;
    }
}
