package com.example.hp.mygaleria;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HP on 13/03/2018.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    ArrayList<Integer> mascotasRanking;
    public MascotaAdapter(ArrayList<Mascota> mascotas){
        this.mascotasRanking= new ArrayList<Integer>();
        this.mascotas=mascotas;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.imgLike.setImageResource(R.drawable.huesob);
        holder.imgLikeObt.setImageResource(R.drawable.hueso);
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvLike.setText(String.valueOf(mascota.getLike()));

        holder.imgLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tvLike.setText(String.valueOf(Integer.parseInt(holder.tvLike.getText().toString())+1));
               // mascotasRanking.add(new Mascota(holder.tvNombre.getText(),Integer.parseInt(holder.tvLike.toString())));
                mascotasRanking.add(position);
                Log.e(" lista " , " LISTADO "+mascotasRanking);
            }
        });
        holder.imgLikeObt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private ImageView imgLike;
        private ImageView imgLikeObt;
        private TextView tvNombre;
        private TextView tvLike;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            imgLike = (ImageView)itemView.findViewById(R.id.ivLike);
            imgLikeObt = (ImageView)itemView.findViewById(R.id.ivLikeObt);
            tvLike = (TextView)itemView.findViewById(R.id.tvLike);
            tvNombre= (TextView)itemView.findViewById(R.id.tvNombre);

        }
    }
}
