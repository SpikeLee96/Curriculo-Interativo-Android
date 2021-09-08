package com.example.projetotesteandroid.util;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    protected Context context;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        inflateViews(itemView);
        this.context = itemView.getContext();

    }

    protected abstract void inflateViews(@NonNull View view);
}
