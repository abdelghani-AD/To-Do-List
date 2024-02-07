package com.example.miniprojetlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    static List<Tache> listHome = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterWork adapterWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.home_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        adapterWork = new AdapterWork(listHome);
        recyclerView.setAdapter(adapterWork);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.icon_add){
            Intent intent = new Intent(Home.this,New_task.class);
            startActivity(intent);
            return true;
        }
        if ( itemId == R.id.icon_menu){
            Intent intent = new Intent(Home.this,ActivityBytton.class);
            startActivity(intent);
            return true;
        }
        if ( itemId == R.id.icn_back) {
            Intent intent = new Intent(Home.this, ActivityBytton.class);
            startActivity(intent);
            return true;
        }
        if (itemId == R.id.icon_delete){
            for (int i=0;i<listHome.size();i++){
                if (listHome.get(i).isCheck()){
                    listHome.remove(i);
                }
            }
            adapterWork = new AdapterWork(listHome);
            recyclerView.setAdapter(adapterWork);
            Toast.makeText(this,"Delete selected",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
