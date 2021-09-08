package com.example.projetotesteandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetotesteandroid.R;

public class AdicionarProjetosActivity extends AppCompatActivity {

    private TextView nomeProjeto;
    private TextView descricao;
    private TextView titleInsert;
    private Button submeter;
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projetos_insert_update_activity);
        setupLayout();
        isUpdate = getIntent().getBooleanExtra("isUpdate", false);
        if (isUpdate) {
            titleInsert.setText("Atualizar Projeto");
            nomeProjeto.setText(getIntent().getStringExtra("nomeProjeto"));
            descricao.setText(getIntent().getStringExtra("descricao"));
        } else {
            titleInsert.setText("Adicionar Projeto");
        }
        setupListener();

    }

    private void setupLayout() {
        nomeProjeto = findViewById(R.id.editText_nomeProjeto_pj);
        descricao = findViewById(R.id.editText_descricao_pj);
        submeter = findViewById(R.id.botao_add);
        titleInsert = findViewById(R.id.title_insert_pj);
    }

    private void adicionar() {
        ProjetosPortfolioActivity.insertItem(nomeProjeto.getText().toString(), descricao.getText().toString());
        final Intent intent = new Intent(AdicionarProjetosActivity.this, ProjetosPortfolioActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);
        finish();
    }

    private void update(){
        ProjetosPortfolioActivity.updateItem(nomeProjeto.getText().toString(), descricao.getText().toString());
        final Intent intent = new Intent(AdicionarProjetosActivity.this, ProjetosPortfolioActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);

        finish();
    }

    private void setupListener() {
        submeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nomeProjeto.getText().toString().isEmpty() && !descricao.getText().toString().isEmpty()) {
                    if (!isUpdate) {
                        adicionar();
                    } else {
                        update();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos.", Toast.LENGTH_LONG);

                }
            }
        });
    }


}
