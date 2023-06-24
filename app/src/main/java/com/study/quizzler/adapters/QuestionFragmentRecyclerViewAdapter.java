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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionFragmentRecyclerViewAdapter extends RecyclerView.Adapter<QuestionFragmentRecyclerViewAdapter.QuestionViewHolder> {
    List<UserQuestion> userQuestionList;


    List<Integer> indeces =  generateRandomIndeces(4,1,5);


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

        // Get the list of answers for the current question
        List<String> answers = new ArrayList<>();
        answers.add(userQuestionList.get(position).getCorrectAnswer());
        answers.addAll(userQuestionList.get(position).getIncorrectAnswers());

        // Shuffle the answers randomly
        Collections.shuffle(answers);

        // Set the randomized answers to the text views
        questionFragmentAnswerOneTextView.setText(answers.get(0));
        questionFragmentAnswerTwoTextView.setText(answers.get(1));
        questionFragmentAnswerThreeTextView.setText(answers.get(2));
        questionFragmentAnswerFourTextView.setText(answers.get(3));

        // Get the index of the correct answer in the shuffled list
        int correctAnswerIndex = answers.indexOf(userQuestionList.get(position).getCorrectAnswer());

        questionFragmentAnswerOneTextView.setOnClickListener(v -> {
            if (correctAnswerIndex == 0) {
                questionFragmentAnswerOneTextView.setBackgroundColor(Color.parseColor("#00FF00"));
            } else {
                questionFragmentAnswerOneTextView.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        questionFragmentAnswerTwoTextView.setOnClickListener(v -> {
            if (correctAnswerIndex == 1) {
                questionFragmentAnswerTwoTextView.setBackgroundColor(Color.parseColor("#00FF00"));
            } else {
                questionFragmentAnswerTwoTextView.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        questionFragmentAnswerThreeTextView.setOnClickListener(v -> {
            if (correctAnswerIndex == 2) {
                questionFragmentAnswerThreeTextView.setBackgroundColor(Color.parseColor("#00FF00"));
            } else {
                questionFragmentAnswerThreeTextView.setBackgroundColor(Color.parseColor("#FF0000"));
            }
        });

        questionFragmentAnswerFourTextView.setOnClickListener(v -> {
            if (correctAnswerIndex == 3) {
                questionFragmentAnswerFourTextView.setBackgroundColor(Color.parseColor("#00FF00"));
            } else {
                questionFragmentAnswerFourTextView.setBackgroundColor(Color.parseColor("#FF0000"));
            }
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

    public static List<Integer> generateRandomIndeces(int count, int min, int max) {
        if (count > (max - min + 1)) {
            throw new IllegalArgumentException("Cannot generate more unique numbers than the range allows.");
        }

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < count) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}
