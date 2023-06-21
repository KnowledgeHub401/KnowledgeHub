package com.study.quizzler.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.study.quizzler.R;
import com.study.quizzler.fragments.QuestionsFragment;

public class Quiz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create Fragment Instance
        QuestionsFragment questionsFragment = new QuestionsFragment();

        // Get Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Fragment Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the fragment to the container
        fragmentTransaction.add(R.id.questionsFragmentFragment, questionsFragment);
        fragmentTransaction.commit();

    }
}
