package com.study.quizzler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.study.quizzler.R;

public class QuestionFragmentRecyclerViewAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View quizQuestionFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_questions, parent, false);
        return new QuestionViewHolder(quizQuestionFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        public QuestionViewHolder(View fragmentItemView) {
            super(fragmentItemView);
        }
    }
}
