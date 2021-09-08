package com.example.projetotesteandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetotesteandroid.R;
import com.example.projetotesteandroid.adapter.CursoAdapter;
import com.example.projetotesteandroid.adapter.HabilidadesAdapter;
import com.example.projetotesteandroid.model.Curso;
import com.example.projetotesteandroid.model.Habilidades;
import com.example.projetotesteandroid.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class HabilidadesActivity extends AppCompatActivity implements OnItemClickListener {

    private Button addCourse;
    private RecyclerView recyclerView;
    public static List<Habilidades> habilidadesList = new ArrayList<>();
    private HabilidadesAdapter habilidadesAdapter;
    private CardView itemView;
    private Button update;
    private Button deletar;
    private static int position;
    private Habilidades habilidades;
    private String toInclude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habilidades_activity);
        setupLayout();
        habilidadesAdapter = new HabilidadesAdapter(this);
        insertStandartCourses();
        setupListeners();
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void setupLayout() {
        addCourse = findViewById(R.id.add_hab);
        recyclerView = findViewById(R.id.dados_recycle_view_hab);
        itemView = findViewById(R.id.card_item_hab);
        update = findViewById(R.id.atualizar_hab);
        deletar = findViewById(R.id.deletar_hab);


    }

    private void setupListeners() {
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(HabilidadesActivity.this, AdicionarHabilidadesActivity.class);
                intent.putExtra("isUpdate", false);
                startActivity(intent);
                finish();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(HabilidadesActivity.this, AdicionarHabilidadesActivity.class);
                intent.putExtra("isUpdate", true);
                intent.putExtra("tipo", habilidadesList.get(position).getTipo());
                intent.putExtra("habilidades", habilidadesList.get(position).getHabilidades());
                startActivity(intent);
                finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (habilidadesList.size() >= 0) {
                    habilidadesList.remove(position);
                    habilidadesAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(habilidadesAdapter);
                    hideButtons();

                }

            }
        });

    }

    private void clearList() {
        if (habilidadesList != null) {
            for (Habilidades habilidades : habilidadesList) {
                habilidades.setSelected(false);
            }
        }
    }


    private void insertStandartCourses() {
        boolean toDo = true;
        if(getIntent().getStringExtra("toInclude") != null){
            toDo = false;
        }

        Habilidades backend = new Habilidades("Back-End", "- Spring Boot, Java - ASP .NET MVC, C# - NodeJS; ");
        Habilidades frontend = new Habilidades("Front-End", " - JavaScript, jQuery - HTML5, CSS3;");
        Habilidades bd = new Habilidades("Banco de Dados", "- PostgreSQL, SQL Server");
        Habilidades mobile = new Habilidades("Mobile", "- iOS, Swift - Android, Java;");
        Habilidades algoritmo = new Habilidades("Algoritmo", "- Python");


        if (toDo) {
            habilidadesList.add(backend);
            habilidadesList.add(frontend);
            habilidadesList.add(bd);
            habilidadesList.add(mobile);
            habilidadesList.add(algoritmo);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        habilidadesAdapter.setHabilidadesList(habilidadesList);
        recyclerView.setAdapter(habilidadesAdapter);
        habilidadesAdapter.notifyDataSetChanged();

    }



    public static void insertItem(String tipo, String habilidades) {
        Habilidades variable = new Habilidades(tipo, habilidades);
        habilidadesList.add(variable);
    }

    public static void updateItem(String tipo, String habilidades) {
        habilidadesList.get(position).setTipo(tipo);
        habilidadesList.get(position).setHabilidades(habilidades);
    }

    private void showButtons() {
        update.setVisibility(View.VISIBLE);
        deletar.setVisibility(View.VISIBLE);
    }

    private void hideButtons() {
        update.setVisibility(View.GONE);
        deletar.setVisibility(View.GONE);
    }

    @Override
    public void onClicked(@NonNull View view, int position) {
        if (position >= 0 && position < habilidadesList.size()) {
            this.position = position;
            habilidades = habilidadesList.get(position);
            showButtons();
            clearList();
            habilidades.setSelected(true);
            habilidadesAdapter.notifyDataSetChanged();
        }

    }
}
