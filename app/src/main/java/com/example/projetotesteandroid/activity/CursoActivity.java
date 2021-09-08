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


import com.example.projetotesteandroid.model.Curso;
import com.example.projetotesteandroid.util.OnItemClickListener;
import com.example.projetotesteandroid.R;
import com.example.projetotesteandroid.adapter.CursoAdapter;

import java.util.ArrayList;
import java.util.List;

public class CursoActivity extends AppCompatActivity implements OnItemClickListener {

    private Button addCourse;
    private RecyclerView recyclerView;
    public static List<Curso> cursos = new ArrayList<>();
    private CursoAdapter cursoAdapter;
    private CardView itemView;
    private Button update;
    private Button deletar;
    private static int position;
    private Curso curso;
    private String toInclude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curso_activity);
        setupLayout();
        cursoAdapter = new CursoAdapter(this);
        insertStandartCourses();
        setupListeners();
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void setupLayout() {
        addCourse = findViewById(R.id.add_curso);
        recyclerView = findViewById(R.id.dados_recycle_view);
        itemView = findViewById(R.id.card_item);
        update = findViewById(R.id.atualizar_curso);
        deletar = findViewById(R.id.deletar_curso);


    }

    private void setupListeners() {
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(CursoActivity.this, AdicionarCursoActivity.class);
                intent.putExtra("isUpdate", false);
                startActivity(intent);
                finish();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(CursoActivity.this, AdicionarCursoActivity.class);
                intent.putExtra("isUpdate", true);
                intent.putExtra("titulo", cursos.get(position).getTitulo());
                intent.putExtra("descricao", cursos.get(position).getDescricao());
                intent.putExtra("certificado", cursos.get(position).getCertificado());
                startActivity(intent);
                finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cursos.size() >= 0) {
                    cursos.remove(position);
                    cursoAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(cursoAdapter);
                    hideButtons();

                }

            }
        });

    }

    private void clearList() {
        if (cursos != null) {
            for (Curso curso : cursos) {
                curso.setSelected(false);
            }
        }
    }


    private void insertStandartCourses() {
        boolean toDo = true;
        if(getIntent().getStringExtra("toInclude") != null){
            toDo = false;
        }

        Curso ios = new Curso("DESENVOLVIMENTO IOS, PORTO MÍDIA", "Curso de desenvolvime nto mobile para o sistema iOS voltado para a criação de " +
                "aplicativos e lançamento deles na app store." +
                "As tecnologias usadas foram linguagem Swift, IDE xcode, e sistema macOS.", "https://drive.google.com/file/d/0B7QJLzt2fIllejN3RkllZ3AxaDNKdVJxRTlKblR3R25WaDln/view");
        Curso s2b = new Curso("MICROSOFT STUDENT 2 BUSSINESS", "Curso de desenvolvimento WEB, envolvendo conceitos de\n" +
                "linguagem orientada à objetos. As tecnologias usadas foram o\n" +
                "framework .NET, a linguagem de programação C#, a linguagem de\n" +
                "marcação HTML/CSS, a linguagem de programação JavaScript e o\n" +
                "banco de dados SQL Server.\n", "https://drive.google.com/file/d/1rMgzXYUyWSxTt1oa85dsE8xoI3Qk5KoQ/view");
        Curso senac = new Curso("CURSO DE INGLÊS, SENAC", "Curso de Inglês pelo SENAC que passa pelo nível Begginers,\n" +
                "até o Advanced.", "https://drive.google.com/file/d/1TD2rGbAZxQ4q470KHpE8RBXxVyecjrR/view?usp=sharing");

        if (toDo) {
            cursos.add(ios);
            cursos.add(s2b);
            cursos.add(senac);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cursoAdapter.setCursoList(cursos);
        recyclerView.setAdapter(cursoAdapter);
        cursoAdapter.notifyDataSetChanged();

    }



    public static void insertItem(String titulo, String descricao, String certificado) {
        Curso variable = new Curso(titulo, descricao, certificado);
        cursos.add(variable);
    }

    public static void updateItem(String titulo, String descricao, String certificado) {
        cursos.get(position).setTitulo(titulo);
        cursos.get(position).setDescricao(descricao);
        cursos.get(position).setCertificado(certificado);
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
        if (position >= 0 && position < cursos.size()) {
            this.position = position;
            curso = cursos.get(position);
            showButtons();
            clearList();
            curso.setSelected(true);
            cursoAdapter.notifyDataSetChanged();
        }

    }
}
