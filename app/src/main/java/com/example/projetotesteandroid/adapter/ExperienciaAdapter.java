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
import com.example.projetotesteandroid.model.Curso;
import com.example.projetotesteandroid.model.ExperienciaProfissional;
import com.example.projetotesteandroid.util.BaseViewHolder;
import com.example.projetotesteandroid.util.OnItemClickListener;

import java.util.List;

public class ExperienciaAdapter extends RecyclerView.Adapter<ExperienciaViewHolder> {

    private final OnItemClickListener listener;
    private List<ExperienciaProfissional> experienciaProfissionals;


    public ExperienciaAdapter(@Nullable OnItemClickListener listener) {
        this.listener = listener;
    }


    public void setExperienciaList(List<ExperienciaProfissional> experienciaProfissionals) {
        this.experienciaProfissionals = experienciaProfissionals;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExperienciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExperienciaViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_experiencia, parent, false), listener);
    }


    @Override
    public void onBindViewHolder(@NonNull ExperienciaViewHolder holder, int position) {
        if (experienciaProfissionals != null) {
            holder.bind(experienciaProfissionals.get(position));

        }
    }

    @Override
    public int getItemCount() {
        if (experienciaProfissionals != null) {
            return experienciaProfissionals.size();
        } else {
            return 0;
        }
    }

}

class ExperienciaViewHolder extends BaseViewHolder implements View.OnClickListener {

    private TextView cargo;
    private TextView local;
    private TextView periodo;
    private TextView descricao;
    private CardView item;
    private ConstraintLayout layout;
    private OnItemClickListener listener;



    @Override
    protected void inflateViews(@NonNull View view) {

        cargo = itemView.findViewById(R.id.editText_nomeProjeto);
        local = itemView.findViewById(R.id.editText_habilidades);
        periodo = itemView.findViewById(R.id.editText_periodo);
        descricao = itemView.findViewById(R.id.editText_descricao);
        layout = itemView.findViewById(R.id.layout_card_exp);
        item = itemView.findViewById(R.id.card_item_exp);

    }

    public ExperienciaViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }


    public void bind(@Nullable ExperienciaProfissional experienciaProfissional) {
        if (experienciaProfissional != null) {
            cargo.setText(experienciaProfissional.getCargo());
            local.setText(experienciaProfissional.getLocal());
            periodo.setText(experienciaProfissional.getPeriodo());
            descricao.setText(experienciaProfissional.getAtividades());

            if (experienciaProfissional.isSelected()) {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                cargo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                local.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                periodo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                descricao.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
            } else {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                cargo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                local.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                periodo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
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
