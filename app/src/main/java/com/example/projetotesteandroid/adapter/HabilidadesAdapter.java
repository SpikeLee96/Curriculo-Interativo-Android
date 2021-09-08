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
import com.example.projetotesteandroid.model.ExperienciaProfissional;
import com.example.projetotesteandroid.model.Habilidades;
import com.example.projetotesteandroid.util.BaseViewHolder;
import com.example.projetotesteandroid.util.OnItemClickListener;

import java.util.List;

public class HabilidadesAdapter extends RecyclerView.Adapter<HabilidadesViewHolder> {

    private final OnItemClickListener listener;
    private List<Habilidades> habilidades;


    public HabilidadesAdapter(@Nullable OnItemClickListener listener) {
        this.listener = listener;
    }


    public void setHabilidadesList(List<Habilidades> habilidades) {
        this.habilidades = habilidades;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HabilidadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HabilidadesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_habilidades, parent, false), listener);
    }


    @Override
    public void onBindViewHolder(@NonNull HabilidadesViewHolder holder, int position) {
        if (habilidades != null) {
            holder.bind(habilidades.get(position));

        }
    }

    @Override
    public int getItemCount() {
        if (habilidades != null) {
            return habilidades.size();
        } else {
            return 0;
        }
    }

}

class HabilidadesViewHolder extends BaseViewHolder implements View.OnClickListener {

    private TextView tipo;
    private TextView habilidade;
    private CardView item;
    private ConstraintLayout layout;
    private OnItemClickListener listener;


    @Override
    protected void inflateViews(@NonNull View view) {

        tipo = itemView.findViewById(R.id.editText_nomeProjeto);
        habilidade = itemView.findViewById(R.id.editText_habilidades);
        layout = itemView.findViewById(R.id.layout_card_hab);
        item = itemView.findViewById(R.id.card_item_hab);

    }

    public HabilidadesViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        itemView.setOnClickListener(this);
    }


    public void bind(@Nullable Habilidades habilidades) {
        if (habilidades != null) {
            tipo.setText(habilidades.getTipo());
            habilidade.setText(habilidades.getHabilidades());

            if (habilidades.isSelected()) {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                tipo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
                habilidade.setBackgroundColor(ContextCompat.getColor(context, R.color.lightslategray));
            } else {
                layout.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                tipo.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
                habilidade.setBackgroundColor(ContextCompat.getColor(context, R.color.lightblue));
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
