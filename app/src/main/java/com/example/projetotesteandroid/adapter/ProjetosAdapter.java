package com.example.projetotesteandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetotesteandroid.R;
import com.example.projetotesteandroid.model.Habilidades;
import com.example.projetotesteandroid.model.ProjetosPortfolio;
import com.example.projetotesteandroid.util.BaseViewHolder;
import com.example.projetotesteandroid.util.OnItemClickListener;

import java.util.List;

public class ProjetosAdapter extends RecyclerView.Adapter<ProjetosViewHolder> {

    private final OnItemClickListener listener;
    private List<ProjetosPortfolio> projetos;


    public ProjetosAdapter(@Nullable OnItemClickListener listener) {
        this.listener = listener;
    }


    public void setProjetoList(List<ProjetosPortfolio> projetosPortfolios) {
        this.projetos = projetosPortfolios;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProjetosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjetosViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_projetos, parent, false), listener);
    }


    @Override
    public void onBindViewHolder(@NonNull ProjetosViewHolder holder, int position) {
        if (projetos != null) {
            holder.bind(projetos.get(position));

        }
    }

    @Override
    public int getItemCount() {
        if (projetos != null) {
            return projetos.size();
        } else {
            return 0;
        }
    }

}

class ProjetosViewHolder extends BaseViewHolder implements View.OnClickListener {

    private TextView nomeProjeto;
    private TextView descricao;
    private CardView item;
    private ConstraintLayout layout;
    private OnItemClickListener listener;


    @Override
    protected void inflateViews(@NonNull View view) {

        nomeProjeto = itemView.findViewById(R.id.edittext_nomeProjeto);
        descricao = itemView.findViewById(R.id.editText_descricaoProjeto);
        layout = itemView.findViewById(R.id.layout_card_proj);
        item = itemView.findViewById(R.id.card_item_proj);

    }

    public ProjetosViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }


    public void bind(@Nullable ProjetosPortfolio projetosPortfolio) {
        if (projetosPortfolio != null) {
            nomeProjeto.setText(projetosPortfolio.getNomeProjeto());
            descricao.setText(projetosPortfolio.getDescricao());

            if (projetosPortfolio.isSelected()) {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                nomeProjeto.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                descricao.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
            } else {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                nomeProjeto.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                descricao.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
            }

        }

    }


    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClicked(view, getAdapterPosition());

        }
    }
}
