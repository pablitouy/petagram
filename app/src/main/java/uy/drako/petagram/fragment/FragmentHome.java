package uy.drako.petagram.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import uy.drako.petagram.R;
import uy.drako.petagram.adapter.MascotaAdaptador;
import uy.drako.petagram.pojo.Mascotas;


public class FragmentHome extends Fragment {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.listaMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        llenarListaMascotas();
        inicializarAdaptador();
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
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
        mascotas.add(new Mascotas(R.drawable.m1,"Marco",5));
        mascotas.add(new Mascotas(R.drawable.m2,"Polo",2));
        mascotas.add(new Mascotas(R.drawable.m1,"Pepito",0));
        mascotas.add(new Mascotas(R.drawable.m2,"Picard",10));
    }
}