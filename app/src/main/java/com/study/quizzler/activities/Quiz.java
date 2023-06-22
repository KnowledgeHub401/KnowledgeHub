package com.study.quizzler.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.quizzler.R;
import com.study.quizzler.fragments.QuestionsFragment;

public class Quiz extends AppCompatActivity {
    private FragmentContainerView questionsFragmentFragmentContainerView;
    private TextView questionFragmentAnswerFourTextView;
    private TextView questionFragmentAnswerThreeTextView;
    private TextView questionFragmentAnswerTwoTextView;
    private TextView questionFragmentAnswerOneTextView;
    private TextView questionsFragmentQuestionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_questions);

        questionsFragmentFragmentContainerView = findViewById(R.id.questionsFragmentFragmentContainerView);
        questionFragmentAnswerFourTextView = findViewById(R.id.questionFragmentAnswerFourTextView);
        questionFragmentAnswerThreeTextView = findViewById(R.id.questionFragmentAnswerThreeTextView);
        questionFragmentAnswerTwoTextView = findViewById(R.id.questionFragmentAnswerTwoTextView);
        questionFragmentAnswerOneTextView = findViewById(R.id.questionFragmentAnswerOneTextView);
        questionsFragmentQuestionTextView = findViewById(R.id.questionsFragmentQuestionTextView);

        // Create Fragment Instance
        QuestionsFragment questionsFragment = new QuestionsFragment();

        // Get Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Fragment Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the fragment to the container
        fragmentTransaction.add(R.id.questionsFragmentFragmentContainerView, questionsFragment);
        fragmentTransaction.commit();

        questionsFragmentRecyclerViewSetUp();

    }

    // Grab Recycler View and set Layout
    private void questionsFragmentRecyclerViewSetUp(){
        RecyclerView questFragRecyclerView = findViewById(R.id.questionPageActivityQuestionsFragmentRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        questFragRecyclerView.setLayoutManager(layoutManager);



    }
}
