package com.example.ansys.hahahaha;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizItemViewHolder> {

    private ArrayList<QuestionBean> questionData;
    private ItemClickListener listener;

    public QuizAdapter(ArrayList<QuestionBean> data, ItemClickListener listener){
        questionData = data;
        this.listener = listener;
    }

    public void setData(ArrayList<QuestionBean> data){
        questionData = data;
    }

    @NonNull
    @Override
    public QuizItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.quiz_item, viewGroup, false);
        return new QuizItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizItemViewHolder viewHolder, int i) {
        QuestionBean questionBean = questionData.get(i);
        viewHolder.textQuizTitle.setText(questionBean.getQuestion());

        final int index = questionBean.getId()-1;
        viewHolder.itemView.setOnClickListener(v -> {
            listener.onItemClick(v, index);
        });
    }

    @Override
    public int getItemCount() {
        if(questionData == null)
            return 0;
        else
            return questionData.size();
    }
}