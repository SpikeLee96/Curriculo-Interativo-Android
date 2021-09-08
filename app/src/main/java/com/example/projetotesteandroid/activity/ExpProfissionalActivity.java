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
import com.example.projetotesteandroid.adapter.ExperienciaAdapter;
import com.example.projetotesteandroid.model.Curso;
import com.example.projetotesteandroid.model.ExperienciaProfissional;
import com.example.projetotesteandroid.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ExpProfissionalActivity extends AppCompatActivity implements OnItemClickListener {

    private Button addCourse;
    private RecyclerView recyclerView;
    public static List<ExperienciaProfissional> experienciaProfissionals = new ArrayList<>();
    private ExperienciaAdapter expAdapter;
    private CardView itemView;
    private Button update;
    private Button deletar;
    private static int position;
    private ExperienciaProfissional experienciaProfissional;
    private String toInclude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.experiencia_activity);
        setupLayout();
        expAdapter = new ExperienciaAdapter(this);
        insertStandartCourses();
        setupListeners();
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void setupLayout() {
        addCourse = findViewById(R.id.add_exp);
        recyclerView = findViewById(R.id.dados_recycle_view_exp);
        itemView = findViewById(R.id.card_item);
        update = findViewById(R.id.atualizar_exp);
        deletar = findViewById(R.id.deletar_exp);
    }

    private void setupListeners() {

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ExpProfissionalActivity.this, AdicionarExperienciaActivity.class);
                intent.putExtra("isUpdate", false);
                startActivity(intent);
                finish();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ExpProfissionalActivity.this, AdicionarExperienciaActivity.class);
                intent.putExtra("isUpdate", true);
                intent.putExtra("cargo", experienciaProfissionals.get(position).getCargo());
                intent.putExtra("periodo", experienciaProfissionals.get(position).getPeriodo());
                intent.putExtra("local", experienciaProfissionals.get(position).getLocal());
                intent.putExtra("atividades", experienciaProfissionals.get(position).getAtividades());
                startActivity(intent);
                finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (experienciaProfissionals.size() >= 0) {
                    experienciaProfissionals.remove(position);
                    expAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(expAdapter);
                    hideButtons();

                }

            }
        });

    }

    private void clearList() {
        if (experienciaProfissionals != null) {
            for (ExperienciaProfissional exp : experienciaProfissionals) {
                experienciaProfissional.setSelected(false);
            }
        }
    }


    private void insertStandartCourses() {
        boolean toDo = true;
        if(getIntent().getStringExtra("toInclude") != null){
            toDo = false;
        }

        ExperienciaProfissional prefeitura = new ExperienciaProfissional("ANALISTA DE SUPORTE TÉCNICO", "01/2020 - 12/2020", "Prefeitura Municipal de Igarassu", "- Suporte técnico em hardware e software para clientesinternos e externos;- Estudo, análise, planejamento, seleção, instalação emanutenção de softwares básicos de apoio;- Configuração e manutenção de impressorascompartilhadas pela rede local;- Instalação e configuração do servidor dos clientes darede online e local;- Interligação das possíveis filiais de rede por WAN atravésde VPN ou outros recursos."); //termiar
        ExperienciaProfissional secretariaPE = new ExperienciaProfissional("ESTAGIÁRIO DE T.I", "08/2018 - 12/2018", "Secretaria de Desenvolvimento Econômico de PE", "- Suporte Técnico ao Usuário Presencial e Remoto;- Configuração de computadores Windows e MacOS;- Implementação e manutenção de softwaresnecessários para a realização das atividades dainstituição;- Reparos na rede da instituição."); //terminar

        if (toDo) {
            experienciaProfissionals.add(prefeitura);
            experienciaProfissionals.add(secretariaPE);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        expAdapter.setExperienciaList(experienciaProfissionals);
        recyclerView.setAdapter(expAdapter);
        expAdapter.notifyDataSetChanged();

    }



    public static void insertItem(String cargo, String periodo, String local, String atividades) {
        ExperienciaProfissional variable = new ExperienciaProfissional(cargo, periodo, local, atividades);
        experienciaProfissionals.add(variable);
    }

    public static void updateItem(String cargo, String periodo, String local, String atividades) {
        experienciaProfissionals.get(position).setCargo(cargo);
        experienciaProfissionals.get(position).setPeriodo(periodo);
        experienciaProfissionals.get(position).setLocal(local);
        experienciaProfissionals.get(position).setAtividades(atividades);
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
        if (position >= 0 && position < experienciaProfissionals.size()) {
            this.position = position;
            experienciaProfissional = experienciaProfissionals.get(position);
            showButtons();
            clearList();
            experienciaProfissional.setSelected(true);
            expAdapter.notifyDataSetChanged();
        }

    }
}
