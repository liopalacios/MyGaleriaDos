package com.example.hp.mygaleria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascota ;
    private RecyclerView recyclerView;
    MascotaAdapter mascotaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar)findViewById(R.id.incActionbar);
        miActionBar.setTitle("mi page mascotas");
        miActionBar.setSubtitle("mi ranking");
        setSupportActionBar(miActionBar);

        recyclerView=(RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icStar:
                Log.e(" CANT "," LOG "+mascotaAdapter.mascotasRanking);
                Intent intent = new Intent(MainActivity.this,RankingActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        mascotaAdapter = new MascotaAdapter(mascota);

        recyclerView.setAdapter(mascotaAdapter);

    }
    public  void inicializarListaMascotas(){
        mascota = new ArrayList<Mascota>();
        mascota.add(new Mascota("pelusa",R.drawable.chancho,18));
        mascota.add(new Mascota("gatorade",R.drawable.gato,13));
        mascota.add(new Mascota("josefino",R.drawable.perro1,14));
        mascota.add(new Mascota("cleopatra",R.drawable.perro2,15));
        mascota.add(new Mascota("pelota",R.drawable.perro3,22));
        mascota.add(new Mascota("princesa",R.drawable.perro4,11));
        mascota.add(new Mascota("pablo",R.drawable.perro5,9));
        mascota.add(new Mascota("lassy",R.drawable.perro6,8));
    }

}
