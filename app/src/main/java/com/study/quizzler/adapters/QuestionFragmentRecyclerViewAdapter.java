package com.study.quizzler.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.UserQuestion;
import com.study.quizzler.R;
import com.study.quizzler.fragments.QuestionsFragment;

import java.util.List;

public class QuestionFragmentRecyclerViewAdapter extends RecyclerView.Adapter<QuestionFragmentRecyclerViewAdapter.QuestionViewHolder> {
    List<UserQuestion> userQuestionList;

    public QuestionFragmentRecyclerViewAdapter (List<UserQuestion> userQuestionList) {
        this.userQuestionList = userQuestionList;
    }

    @NonNull
    @Override
    public QuestionFragmentRecyclerViewAdapter.QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View quizQuestionFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_questions, parent, false);
        return new QuestionViewHolder(quizQuestionFragment);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionFragmentRecyclerViewAdapter.QuestionViewHolder holder, int position) {
        TextView questionFragmentAnswerFourTextView = holder.itemView.findViewById(R.id.questionFragmentAnswerFourTextView);
        TextView questionFragmentAnswerThreeTextView = holder.itemView.findViewById(R.id.questionFragmentAnswerThreeTextView);
        TextView questionFragmentAnswerTwoTextView = holder.itemView.findViewById(R.id.questionFragmentAnswerTwoTextView);
        TextView questionFragmentAnswerOneTextView = holder.itemView.findViewById(R.id.questionFragmentAnswerOneTextView);
        TextView questionsFragmentQuestionTextView = holder.itemView.findViewById(R.id.questionsFragmentQuestionTextView);

        questionsFragmentQuestionTextView.setText(userQuestionList.get(position).getQuestion());
        questionFragmentAnswerOneTextView.setText(userQuestionList.get(position).getCorrectAnswer());
        questionFragmentAnswerTwoTextView.setText(userQuestionList.get(position).getIncorrectAnswers().get(0));
        questionFragmentAnswerThreeTextView.setText(userQuestionList.get(position).getIncorrectAnswers().get(1));
        questionFragmentAnswerFourTextView.setText(userQuestionList.get(position).getIncorrectAnswers().get(2));

        questionFragmentAnswerOneTextView.setOnClickListener(v -> {
            questionFragmentAnswerOneTextView.setBackgroundColor(Color.parseColor("#00FF00"));

        });
        questionFragmentAnswerTwoTextView.setOnClickListener(v -> {
            questionFragmentAnswerTwoTextView.setBackgroundColor(Color.parseColor("#FF0000"));
        });
        questionFragmentAnswerThreeTextView.setOnClickListener(v -> {
            questionFragmentAnswerThreeTextView.setBackgroundColor(Color.parseColor("#FF0000"));
        });
        questionFragmentAnswerFourTextView.setOnClickListener(v -> {
            questionFragmentAnswerFourTextView.setBackgroundColor(Color.parseColor("#FF0000"));
        });
    }

    @Override
    public int getItemCount() {
        return userQuestionList.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        public QuestionViewHolder(View fragmentItemView) {
            super(fragmentItemView);
        }
    }
}
