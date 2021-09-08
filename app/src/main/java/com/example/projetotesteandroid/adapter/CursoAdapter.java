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

import com.example.projetotesteandroid.util.BaseViewHolder;
import com.example.projetotesteandroid.model.Curso;
import com.example.projetotesteandroid.util.OnItemClickListener;
import com.example.projetotesteandroid.R;

import java.util.List;

public class CursoAdapter extends RecyclerView.Adapter<cursoViewHolder> {

    private final OnItemClickListener listener;
    private List<Curso> curso;


    public CursoAdapter(@Nullable OnItemClickListener listener) {
        this.listener = listener;
    }


    public void setCursoList(List<Curso> cursos) {
        this.curso = cursos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public cursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cursoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_curso, parent, false), listener);
    }


    @Override
    public void onBindViewHolder(@NonNull cursoViewHolder holder, int position) {
        if (curso != null) {
            holder.bind(curso.get(position));

        }
    }

    @Override
    public int getItemCount() {
        if (curso != null) {
            return curso.size();
        } else {
            return 0;
        }
    }

}

class cursoViewHolder extends BaseViewHolder implements View.OnClickListener {

    private TextView titulo;
    private TextView descricao;
    private TextView certificado;
    private CardView item;
    private ConstraintLayout layout;
    private OnItemClickListener listener;


    @Override
    protected void inflateViews(@NonNull View view) {

        titulo = itemView.findViewById(R.id.editText_nomeProjeto);
        descricao = itemView.findViewById(R.id.editText_habilidades);
        certificado = itemView.findViewById(R.id.editText_periodo);
        layout = itemView.findViewById(R.id.layout_card);
        item = itemView.findViewById(R.id.card_item);

    }

    public cursoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }


    public void bind(@Nullable Curso curso) {
        if (curso != null) {
            titulo.setText(curso.getTitulo());
            descricao.setText(curso.getDescricao());
            certificado.setText(curso.getCertificado());
            if (curso.isSelected()) {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                titulo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                descricao.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                certificado.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
            } else {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                titulo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                descricao.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                certificado.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
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
