package com.example.projetotesteandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetotesteandroid.R;

public class MainActivity extends AppCompatActivity {

    private Button contato;
    private Button objetivo;
    private Button graduacao;
    private Button addCourse;
    private Button expProfissional;
    private Button habilidades;
    private Button projetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trackButtons();
        setupListeners();
    }

    private void trackButtons(){
        contato = findViewById(R.id.contato);
        objetivo = findViewById(R.id.objetivo);
        graduacao = findViewById(R.id.graduacao);
        addCourse = findViewById(R.id.curso);
        expProfissional = findViewById(R.id.exp_profissional);
        habilidades = findViewById(R.id.habilidades);
        projetos = findViewById(R.id.projetos);
    }


    private void setupListeners(){
        contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContatoActivity.class));
            }
        });
        objetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ObjetivoActivity.class));
            }
        });
        graduacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GraduacaoActivity.class));
            }
        });
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CursoActivity.class));
            }
        });
        expProfissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ExpProfissionalActivity.class));
            }
        });
        habilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HabilidadesActivity.class));
            }
        });
        projetos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProjetosPortfolioActivity.class));
            }
        });
    }
}