package com.example.hp.mygaleria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {
    ArrayList<Mascota> mascota ;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Toolbar miActionBar = (Toolbar)findViewById(R.id.incActionbar);
        miActionBar.setTitle("mi page mascotas");
        miActionBar.setSubtitle("mi ranking");
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=(RecyclerView)findViewById(R.id.rvMascotasRanking);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public void inicializarAdaptador(){
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascota);
        recyclerView.setAdapter(mascotaAdapter);

    }
    public  void inicializarListaMascotas(){
        mascota = new ArrayList<Mascota>();
        mascota.add(new Mascota("pelusa",R.drawable.chancho,64));
        mascota.add(new Mascota("gatorade",R.drawable.gato,47));
        mascota.add(new Mascota("josefino",R.drawable.perro1,88));
        mascota.add(new Mascota("cleopatra",R.drawable.perro2,56));
    }
}
