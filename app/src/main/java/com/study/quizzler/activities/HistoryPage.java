package com.study.quizzler.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import com.amplifyframework.api.graphql.model.ModelPagination;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Question;
import com.amplifyframework.datastore.generated.model.UserQuestion;
import com.google.android.material.navigation.NavigationView;
import com.study.quizzler.R;
import com.study.quizzler.fragments.QuestionsFragment;
import com.study.quizzler.listeners.NavigationItemSelectedListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HistoryPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    String selected;
    List<UserQuestion> userHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);

        // Initialize the ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the custom NavigationItemSelectedListener
        NavigationItemSelectedListener navigationItemSelectedListener = new NavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);

        // Create Fragment Instance
        QuestionsFragment questionsFragment= new QuestionsFragment();

        // Get Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Fragment Transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the fragment to the container
        fragmentTransaction.add(R.id.questionsFragmentFragment, questionsFragment);
        fragmentTransaction.commit();




    }

    protected void onResume() {
        super.onResume();
        userHistory.clear();
        getUserQuestions();
    }

    public void setUpCorrectAnswersButton () {
        Button correctAnswersButton = (Button) findViewById(R.id.historyActivityCorrectAnswersButton);
        correctAnswersButton.setOnClickListener(v -> {
            selected = "true";
            getUserQuestions();
        });
    }

    public void setUpIncorrectAnswersButton () {
        Button correctAnswersButton = (Button) findViewById(R.id.historyActivityIncorrectAnswersButton);
        correctAnswersButton.setOnClickListener(v -> {
            selected = "false";
            getUserQuestions();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    void getUserQuestions() {
        if (selected.equals("all")) {
            Amplify.API.query(
                    ModelQuery.list(UserQuestion.class),
                    response -> {
                        for (UserQuestion question : response.getData()) {
                           userHistory.add(question);
                        }
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );
        } else {
            Amplify.API.query(
                    ModelQuery.list(UserQuestion.class, UserQuestion.ANSWERED_CORRECTLY.eq(Boolean.valueOf(selected))),
                    response -> {
                        for (UserQuestion question : response.getData()) {
                            userHistory.add(question);
                        }
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );
        }
    }
}
