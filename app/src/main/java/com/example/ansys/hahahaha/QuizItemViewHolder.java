package com.example.ansys.hahahaha;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class QuizItemViewHolder extends RecyclerView.ViewHolder {
    TextView textQuizTitle;

    public QuizItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textQuizTitle = itemView.findViewById(R.id.QuizTitleText);
    }
}