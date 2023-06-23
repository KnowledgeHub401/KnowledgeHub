package com.study.quizzler.activities;

import static com.study.quizzler.MainActivity.questions;
import static java.util.Map.of;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amplifyframework.api.graphql.model.ModelPagination;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Question;
import com.amplifyframework.datastore.generated.model.UserQuestion;
import com.study.quizzler.R;
import com.study.quizzler.fragments.QuestionsFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class QuizActivity extends AppCompatActivity {

    private FragmentContainerView questionsFragmentFragmentContainerView;
    private TextView questionFragmentAnswerFourTextView;
    private TextView questionFragmentAnswerThreeTextView;
    private TextView questionFragmentAnswerTwoTextView;
    private TextView questionFragmentAnswerOneTextView;
    private TextView questionsFragmentQuestionTextView;


    private static final String TAG = "Quiz";

    Intent intent = getIntent();
    String selected = intent.getStringExtra("selected_category");


    List<UserQuestion> quizQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

//        questionsFragmentFragmentContainerView = findViewById(R.id.questionsFragmentFragmentContainerView);
//        questionFragmentAnswerFourTextView = findViewById(R.id.questionFragmentAnswerFourTextView);
//        questionFragmentAnswerThreeTextView = findViewById(R.id.questionFragmentAnswerThreeTextView);
//        questionFragmentAnswerTwoTextView = findViewById(R.id.questionFragmentAnswerTwoTextView);
//        questionFragmentAnswerOneTextView = findViewById(R.id.questionFragmentAnswerOneTextView);
//        questionsFragmentQuestionTextView = findViewById(R.id.questionsFragmentQuestionTextView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selected = extras.getString("selected_category");
        }
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

    protected void onResume() {
        super.onResume();
        getQuestions();
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

    protected void getQuestions() {


//        Amplify.API.query(
//                ModelQuery.list(UserQuestion.class),
//                success -> {
//
//                    for(UserQuestion question : success.getData()){
//                        userQuestionMap.put(question.getId(), question);
//                    }
//                },
//                failure -> {
//                    Log.i(TAG,"Did not read questions successfully");
//                }`
//        );

        if (selected.equals("all")) {
            List<Integer> randomIndeces = generateRandomIndeces(10,0,249);
            for(Integer index : randomIndeces) {
                Question question = questions.get(index);
                UserQuestion userQuestion = UserQuestion.builder()
                        .category(question.getCategory())
                        .type(question.getType())
                        .difficulty(question.getDifficulty())
                        .question(question.getQuestion())
                        .correctAnswer(question.getCorrectAnswer())
                        .incorrectAnswers(question.getIncorrectAnswers())
                        .build();
                quizQuestions.add(userQuestion);
            }
//            Amplify.API.query(
//                    ModelQuery.list(Question.class, ModelPagination.limit(10)),
//                    response -> {
//                        Collections.shuffle(Collections.singletonList(response.getData()));
//                        for (Question question : response.getData()) {
//                            if (userQuestionMap.containsKey(question.getId())) {
//                                quizQuestions.add(userQuestionMap.get(question.getId()));
//                            } else {
//                                UserQuestion userQuestion = UserQuestion.builder()
//                                        .category(question.getCategory())
//                                        .type(question.getType())
//                                        .difficulty(question.getDifficulty())
//                                        .question(question.getQuestion())
//                                        .correctAnswer(question.getCorrectAnswer())
//                                        .incorrectAnswers(question.getIncorrectAnswers())
//                                        .build();
//                                quizQuestions.add(userQuestion);
//                            }randomIndices
//
//                    },
//                    error -> Log.e("MyAmplifyApp", "Query failure", error)
//            );
        } else {
            List<Question> curatedQuestions = new ArrayList<>();
            for(Map.Entry<Integer,Question> questionNode : questions.entrySet()) {
                if (questionNode.getValue().getCategory().equals(selected)) {
                    curatedQuestions.add(questionNode.getValue());
                }
            }
            List<Integer> randomIndices = generateRandomIndeces(10,0,49);
            for(Integer index : randomIndices) {
                Question question = curatedQuestions.get(index);
                UserQuestion userQuestion = UserQuestion.builder()
                        .category(question.getCategory())
                        .type(question.getType())
                        .difficulty(question.getDifficulty())
                        .question(question.getQuestion())
                        .correctAnswer(question.getCorrectAnswer())
                        .incorrectAnswers(question.getIncorrectAnswers())
                        .build();
                quizQuestions.add(userQuestion);
            }
//            Amplify.API.query(
//                    ModelQuery.list(Question.class, Question.CATEGORY.contains(selected), ModelPagination.limit(10)),
//                    response -> {
//                        Collections.shuffle(Collections.singletonList(response.getData()));
//                        for (Question question : response.getData()) {
//                            if (userQuestionMap.containsKey(question.getId())) {
//                                quizQuestions.add(userQuestionMap.get(question.getId()));
//                            } else {
//                                UserQuestion userQuestion = UserQuestion.builder()
//                                        .category(question.getCategory())
//                                        .type(question.getType())
//                                        .difficulty(question.getDifficulty())
//                                        .question(question.getQuestion())
//                                        .correctAnswer(question.getCorrectAnswer())
//                                        .incorrectAnswers(question.getIncorrectAnswers())
//                                        .build();
//                                quizQuestions.add(userQuestion);
//                            }
//                        }
//
//                    },
//                    error -> Log.e("MyAmplifyApp", "Query failure", error));
        }
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
//                .expressionAttributeNames(Collections.singletonMap("#pk", "your_partition_key"))
//                .expressionAttributeValues(expressionAttributeValues)
//                .limit(itemCount)
//                .build();

//        // Execute the query
//        QueryResponse queryResponse = dynamoDbClient.query(queryRequest);
//        // Process the query results
//        for (Map<String, AttributeValue> item : queryResponse.items()) {
//            // Process each item as needed
//            if (userQuestionMap.containsKey(item.get("id"))){
//                quizQuestions.add(userQuestionMap.get(item.get("id")));
//            }
//            else {
//                List<String> incorrectAnswers = new ArrayList<>();
//                List<AttributeValue> incorrectAnswersAttributeList = item.get("incorrect_answers").l();
//                for (AttributeValue attributeValue : incorrectAnswersAttributeList) {
//                    incorrectAnswers.add(attributeValue.s());
//                }
//
//                UserQuestion userQuestion = UserQuestion.builder()
//                        .category((CategoryEnum.valueOf(item.get("category").s())))
//                        .type(item.get("type").s())
//                        .difficulty((DifficultyEnum.valueOf(item.get("difficulty").s())))
//                        .question(item.get("question").s())
//                        .correctAnswer(item.get("correct_answer").s())
//                        .incorrectAnswers(incorrectAnswers)
//                        .build();
//                quizQuestions.add(userQuestion);
//            }
//        }
    }

//    public void submitQuiz () {
//        submitButton.setOnClickListener(v -> {
//            for (UserQuestion question : quizQuestions) {
//                if (question.correct_answer == selected){
//                    question.answeredCorrectly = true;
//                } else {
//                    question.answeredCorrectly = false;
//                }
//                Amplify.DataStore.save(question,
//                        success -> Log.i(TAG, "Saved TriviaQuestion: " + success.item().getId()),
//                        error -> Log.e(TAG, "Failed to save TriviaQuestion: " + error));
//            }
//        });
//    }
}
