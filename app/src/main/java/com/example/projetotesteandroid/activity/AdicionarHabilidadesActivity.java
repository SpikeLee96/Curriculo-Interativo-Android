package com.example.projetotesteandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetotesteandroid.R;

public class AdicionarHabilidadesActivity extends AppCompatActivity {

    private TextView tipo;
    private TextView habilidades;
    private TextView titleInsert;
    private Button submeter;
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habilidades_insert_update_activity);
        setupLayout();
        isUpdate = getIntent().getBooleanExtra("isUpdate", false);
        if (isUpdate) {
            titleInsert.setText("Atualizar Habilidades");
            tipo.setText(getIntent().getStringExtra("tipo"));
            habilidades.setText(getIntent().getStringExtra("habilidades"));
        } else {
            titleInsert.setText("Adicionar Habilidades");
        }
        setupListener();

    }

    private void setupLayout() {
        tipo = findViewById(R.id.editText_tipo_hab);
        habilidades = findViewById(R.id.editText_descricao_hab);
        submeter = findViewById(R.id.botao_add);
        titleInsert = findViewById(R.id.title_insert);
    }

    private void adicionar() {
        HabilidadesActivity.insertItem(tipo.getText().toString(), habilidades.getText().toString());
        final Intent intent = new Intent(AdicionarHabilidadesActivity.this, HabilidadesActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);
        finish();
    }

    private void update(){
        HabilidadesActivity.updateItem(tipo.getText().toString(), habilidades.getText().toString());
        final Intent intent = new Intent(AdicionarHabilidadesActivity.this, HabilidadesActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);

        finish();
    }

    private void setupListener() {
        submeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tipo.getText().toString().isEmpty() && !habilidades.getText().toString().isEmpty()) {
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
