package com.example.projetotesteandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetotesteandroid.R;

public class AdicionarCursoActivity extends AppCompatActivity {

    private TextView titulo;
    private TextView descricao;
    private TextView certificado;
    private TextView titleInsert;
    private Button submeter;
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_update_activity);
        setupLayout();
        isUpdate = getIntent().getBooleanExtra("isUpdate", false);
        if (isUpdate) {
            titleInsert.setText("Atualizar Curso");
            titulo.setText(getIntent().getStringExtra("titulo"));
            descricao.setText(getIntent().getStringExtra("descricao"));
            certificado.setText(getIntent().getStringExtra("certificado"));
        } else {
            titleInsert.setText("Adicionar Curso");
        }
        setupListener();

    }

    private void setupLayout() {
        titulo = findViewById(R.id.editText_nomeProjeto);
        descricao = findViewById(R.id.editText_habilidades);
        certificado = findViewById(R.id.editText_periodo);
        submeter = findViewById(R.id.botao_add);
        titleInsert = findViewById(R.id.title_insert);
    }

    private void adicionar() {
        CursoActivity.insertItem(titulo.getText().toString(), descricao.getText().toString(), certificado.getText().toString());
        final Intent intent = new Intent(AdicionarCursoActivity.this, CursoActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);
        finish();
    }

    private void update(){
        CursoActivity.updateItem(titulo.getText().toString(), descricao.getText().toString(), certificado.getText().toString());
        final Intent intent = new Intent(AdicionarCursoActivity.this, CursoActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);

        finish();
    }

    private void setupListener() {
        submeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!titulo.getText().toString().isEmpty() && !descricao.getText().toString().isEmpty() && !certificado.getText().toString().isEmpty()) {
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
