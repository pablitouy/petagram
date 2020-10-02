package uy.drako.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    public MascotaAdaptador( ArrayList<Mascotas> mascotas){
        this.actividad = actividad;
        this.mascotas = mascotas;
    }
    ArrayList<Mascotas> mascotas;
    Activity actividad;
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvLike.setText(""+mascota.getLike());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends ViewHolder{
        private ImageView imgFoto, imgHueso, imgHuesoLike;
        private TextView tvMascota;
        private TextView tvLike;
        public MascotaViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgHueso = (ImageView) itemView.findViewById(R.id.imgHueso);
            imgHuesoLike = (ImageView) itemView.findViewById(R.id.imgHuesoLike);
            tvMascota = (TextView) itemView.findViewById(R.id.tvMascota);
            tvLike = (TextView) itemView.findViewById(R.id.tvLike);
            imgHueso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int auxNumLikes = Integer.parseInt(tvLike.getText().toString());
                    if(auxNumLikes >= 1) {
                        tvLike.setText("" + (auxNumLikes - 1));
                    }
                    //makeText(actividad,itemView.getResources().getString(R.string.MensajeLike)+tvMascota.getText().toString(), LENGTH_SHORT).show();
                }
            });
            imgHuesoLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int auxNumLikes = Integer.parseInt(tvLike.getText().toString());
                    tvLike.setText(""+(auxNumLikes+1));
                    //makeText(actividad,itemView.getResources().getString(R.string.MensajeLike)+tvMascota.getText().toString(), LENGTH_SHORT).show();
                }
            });
        }
    }
}
