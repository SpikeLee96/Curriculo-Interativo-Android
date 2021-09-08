package com.example.projetotesteandroid.util;

import android.view.View;

import androidx.annotation.NonNull;

public interface OnItemClickListener {
    void onClicked(@NonNull View view, int position);
}
