package uy.drako.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    private ImageView imgFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaMascotas = (RecyclerView)findViewById(R.id.listaMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        llenarListaMascotas();
        inicializarAdaptador();
        imgFav =(ImageView)findViewById(R.id.imgStar);
        imgFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento =new Intent(MainActivity.this,Favoritos.class);
                ArrayList<Mascotas> milista = new ArrayList<Mascotas>();
                intento.putExtra("mascotas", milista);

                startActivity(intento);
            }
        });


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