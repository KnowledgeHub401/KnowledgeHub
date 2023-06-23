package com.study.quizzler.activities;

import android.os.Bundle;

import android.widget.TextView;

import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.UserQuestion;
import com.study.quizzler.R;
import com.study.quizzler.fragments.QuestionsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz extends AppCompatActivity {

    private FragmentContainerView questionsFragmentFragmentContainerView;
    private TextView questionFragmentAnswerFourTextView;
    private TextView questionFragmentAnswerThreeTextView;
    private TextView questionFragmentAnswerTwoTextView;
    private TextView questionFragmentAnswerOneTextView;
    private TextView questionsFragmentQuestionTextView;


    private static final String TAG = "Quiz";

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

//    protected void onResume() {
//        super.onResume();
//
//        List<UserQuestion> quizQuestions = new ArrayList<>();
//
//        Map<String, UserQuestion> userQuestionMap = new HashMap<>();
//        Amplify.API.query(
//                ModelQuery.list(UserQuestion.class),
//                success -> {
//
//                    for(UserQuestion question : success.getData()){
//                        userQuestionMap.put(question.getID(), question);
//                    }
//                },
//                failure -> {
//                    Log.i(TAG,"Did not read tasks successfully");
//                }
//        );
//
//        DynamoDbClient dynamoDbClient = DynamoDbClient.create();
//        // Specify the table name
//        String tableName = "YourTableName";
//        // Specify the number of random items you want to retrieve
//        int itemCount = 10;
//        // Generate a random offset to start retrieving items
//        int randomOffset = (int) (Math.random() * Integer.MAX_VALUE);
//        // Build the query request
//        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
//        expressionAttributeValues.put(":offset", AttributeValue.builder().n(Integer.toString(randomOffset)).build());
//        QueryRequest queryRequest = QueryRequest.builder()
//                .tableName(tableName)
//                .keyConditionExpression("#pk = :offset")
//                .expressionAttributeNames(Map.of("#pk", "your_partition_key"))
//                .expressionAttributeValues(expressionAttributeValues)
//                .limit(itemCount)
//                .build();
//        // Execute the query
//        QueryResponse queryResponse = dynamoDbClient.query(queryRequest);
//        // Process the query results
//        for (Map<String, AttributeValue> item : queryResponse.items()) {
//            // Process each item as needed
//            if (userQuestionMap.containsKey(item.get("id"))){
//                quizQuestions.add(userQuestionMap.get(question.getQuestion()));
//            }
//            else {
//                UserQuestion userQuestion = new UserQuestion.builder()
//                        .category(item.get("category")
//                                .type(item.get("type"))
//                                .difficulty(item.get("difficulty"))
//                                .question(item.get("question"))
//                                .incorrect_answers(item.get("incorrect_answers"))
//                        );
//                quizQuestions.add(userQuestion);
//            }
//        }
//
//    }
//
//    public void submitQuiz() {
//        submitButton.setOnClickListener(v -> {
//            for (UserQuestion question : quizQuestions) {
//                if (question.correct_answer == selected){
//                    question.answeredCorrectly = true;
//                } else {
//                    question.answeredCorrectly = false;
//                }
//
//            }
//            Amplify.DataStore.save(question,
//                    success -> Log.i(TAG, "Saved TriviaQuestion: " + success.item().getId()),
//                    error -> Log.e(TAG, "Failed to save TriviaQuestion: " + error)
//            );
//        });
//    }

}
