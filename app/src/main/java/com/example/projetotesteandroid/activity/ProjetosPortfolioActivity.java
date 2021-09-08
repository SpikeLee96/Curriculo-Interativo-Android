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
import com.example.projetotesteandroid.adapter.ProjetosAdapter;
import com.example.projetotesteandroid.model.Curso;
import com.example.projetotesteandroid.model.ProjetosPortfolio;
import com.example.projetotesteandroid.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ProjetosPortfolioActivity extends AppCompatActivity implements OnItemClickListener {

    private Button addCourse;
    private RecyclerView recyclerView;
    public static List<ProjetosPortfolio> projetosList = new ArrayList<>();
    private ProjetosAdapter projetosAdapter;
    private CardView itemView;
    private Button update;
    private Button deletar;
    private static int position;
    private ProjetosPortfolio projetos;
    private String toInclude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projetos_activity);
        setupLayout();
        projetosAdapter = new ProjetosAdapter(this);
        insertStandartCourses();
        setupListeners();
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void setupLayout() {
        addCourse = findViewById(R.id.add_pj);
        recyclerView = findViewById(R.id.dados_recycle_view_pj);
        itemView = findViewById(R.id.card_item_proj);
        update = findViewById(R.id.atualizar_pj);
        deletar = findViewById(R.id.deletar_pj);


    }

    private void setupListeners() {
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ProjetosPortfolioActivity.this, AdicionarProjetosActivity.class);
                intent.putExtra("isUpdate", false);
                startActivity(intent);
                finish();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(ProjetosPortfolioActivity.this, AdicionarProjetosActivity.class);
                intent.putExtra("isUpdate", true);
                intent.putExtra("nomeProjeto", projetosList.get(position).getNomeProjeto());
                intent.putExtra("descricao", projetosList.get(position).getDescricao());
                startActivity(intent);
                finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (projetosList.size() >= 0) {
                    projetosList.remove(position);
                    projetosAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(projetosAdapter);
                    hideButtons();

                }

            }
        });

    }

    private void clearList() {
        if (projetosList != null) {
            for (ProjetosPortfolio projeto : projetosList) {
                projeto.setSelected(false);
            }
        }
    }


    private void insertStandartCourses() {
        boolean toDo = true;
        if(getIntent().getStringExtra("toInclude") != null){
            toDo = false;
        }

        ProjetosPortfolio congredu = new ProjetosPortfolio("Projeto Congredu", "Aplicativo Node.jscom propósito de promover um congressoeducacional, contendo nele cronograma depalestras, cadastro de usuários associados,informações sobre comissõesorganizadoras, normas de trabalho, e etc;");
        ProjetosPortfolio congreduSpringBoot = new ProjetosPortfolio("Projeto Congredu Spring Boot", "Mesmoprojeto citado acima, mas com melhorias defuncionalidades extras utilizando oframework Spring Boot, de Java;");
        ProjetosPortfolio batalhasMedievais = new ProjetosPortfolio("Batalhas Medievais", "Aplicativo paraiOS/Swift do qual consiste em um jogo deopções, onde o jogador seleciona osataques e defesas disponíveis para cadaclasse;");
        ProjetosPortfolio organoBusca = new ProjetosPortfolio("Organo Busca", "Aplicativo ASP .NET MVCdesenvolvido com intenção de oferecer ummecanismo de busca de feiras orgânicas naregião metropolitana de Recife, onde osfeirantes e clientes poderiam se cadastrarpara ter acesso a todas as funcionalidadeda plataforma.");
        ProjetosPortfolio curriculoAndroid = new ProjetosPortfolio("Currículo Android", "Currículo pessoal feito como um aplicativo Android.");

        if (toDo) {
            projetosList.add(congredu);
            projetosList.add(congreduSpringBoot);
            projetosList.add(batalhasMedievais);
            projetosList.add(organoBusca);
            projetosList.add(curriculoAndroid);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        projetosAdapter.setProjetoList(projetosList);
        recyclerView.setAdapter(projetosAdapter);
        projetosAdapter.notifyDataSetChanged();

    }



    public static void insertItem(String nomeProjeto, String descricao) {
        ProjetosPortfolio variable = new ProjetosPortfolio(nomeProjeto, descricao);
        projetosList.add(variable);
    }

    public static void updateItem(String nomeProjeto, String descricao) {
        projetosList.get(position).setNomeProjeto(nomeProjeto);
        projetosList.get(position).setDescricao(descricao);
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
        if (position >= 0 && position < projetosList.size()) {
            this.position = position;
            projetos = projetosList.get(position);
            showButtons();
            clearList();
            projetos.setSelected(true);
            projetosAdapter.notifyDataSetChanged();
        }

    }
}
