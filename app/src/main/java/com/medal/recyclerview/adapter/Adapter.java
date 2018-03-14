package com.medal.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.medal.recyclerview.R;
import com.medal.recyclerview.model.Filme;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by adria on 02/03/2018.
 */

    public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

        private List<Filme> listaFilmes;

        public Adapter(List<Filme> lista) {
            this.listaFilmes = lista;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

            public MyViewHolder(View itemView) {
                super(itemView);

                titulo = itemView.findViewById(R.id.textTitulo);
                ano = itemView.findViewById(R.id.textAno);
                genero = itemView.findViewById(R.id.textGenero);
            }
        }

}
