package com.medal.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.medal.recyclerview.R;
import com.medal.recyclerview.RecyclerItemClickListener;
import com.medal.recyclerview.adapter.Adapter;
import com.medal.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //listagm de filmes
        this.criarFilmes();

        //configurar adapter
        Adapter adapter = new Adapter(listaFilmes);

        //configurar ReciclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplication());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(),
                        recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Item presionado: "
                                + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click Longo: "
                                + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                })
        );

    }

    public void criarFilmes(){

        Filme filme = new Filme("Homem aranha - Devolta pra casa", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Assassin’s Creed", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Logan", "Ação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Cinquenta Tons Mais Escuros", "Romance", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Cabana", "Drama", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Power Rangers", "Fantasia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Vigilante do Amanhã: Ghost in the Shell", "Ficção científica", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Guardiões da Galáxia 2", "Aventura", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Piratas do Caribe: A Vingança de Salazar", "Fantasia", "2017");
        this.listaFilmes.add(filme);
    }

}
