package uy.drako.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFav);
        setSupportActionBar(miActionBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        listaMascotas = (RecyclerView)findViewById(R.id.listaMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        ArrayList<Mascotas> lista = (ArrayList<Mascotas>) getIntent().getSerializableExtra("mascotas");

        llenarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);

    }

    public void llenarListaMascotas(){
        mascotas = new ArrayList<Mascotas>();
        mascotas.add(new Mascotas(R.drawable.m1,"Ronco",5));
        mascotas.add(new Mascotas(R.drawable.m2,"Rufus",2));
        mascotas.add(new Mascotas(R.drawable.m1,"Pepe",0));
        mascotas.add(new Mascotas(R.drawable.m2,"Julius",10));
    }

    @Override
    protected void onResume() {
        super.onResume();
        
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}