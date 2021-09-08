package com.example.projetotesteandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetotesteandroid.R;

public class AdicionarExperienciaActivity extends AppCompatActivity {

    private TextView cargo;
    private TextView periodo;
    private TextView local;
    private TextView atividades;
    private TextView titleInsert;
    private Button submeter;
    private boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_insert_update_activity); //mudar
        setupLayout();
        isUpdate = getIntent().getBooleanExtra("isUpdate", false);
        if (isUpdate) {
            titleInsert.setText("Atualizar Experiência");
            cargo.setText(getIntent().getStringExtra("cargo")); //mudar
            periodo.setText(getIntent().getStringExtra("periodo")); //mudar
            local.setText(getIntent().getStringExtra("local")); //mudar
            atividades.setText(getIntent().getStringExtra("atividades"));
        } else {
            titleInsert.setText("Adicionar Experiência");
        }
        setupListener();

    }

    private void setupLayout() { //mudar
        cargo = findViewById(R.id.editText_cargo_exp);
        periodo = findViewById(R.id.editText_periodo_exp);
        local = findViewById(R.id.editText_local_exp);
        atividades = findViewById(R.id.editText_atividades_exp);
        submeter = findViewById(R.id.botao_add);
        titleInsert = findViewById(R.id.title_insert);
    }

    private void adicionar() {
        ExpProfissionalActivity.insertItem(cargo.getText().toString(), periodo.getText().toString(), local.getText().toString(), atividades.getText().toString()); //mudar
        final Intent intent = new Intent(AdicionarExperienciaActivity.this, ExpProfissionalActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);
        finish();
    }

    private void update(){
        ExpProfissionalActivity.updateItem(cargo.getText().toString(), periodo.getText().toString(), local.getText().toString(), atividades.getText().toString()); //mudar
        final Intent intent = new Intent(AdicionarExperienciaActivity.this, ExpProfissionalActivity.class);
        intent.putExtra("toInclude","false");
        startActivity(intent);

        finish();
    }

    private void setupListener() {
        submeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cargo.getText().toString().isEmpty() && !periodo.getText().toString().isEmpty() && !local.getText().toString().isEmpty() && !atividades.getText().toString().isEmpty()) {
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
