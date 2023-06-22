package com.study.quizzler;



import static com.amplifyframework.core.Amplify.Auth;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.google.android.material.navigation.NavigationView;
import com.study.quizzler.adapters.ButtonAdapter;
import com.study.quizzler.helpers.GridSpacingItemDecoration;
import com.study.quizzler.listeners.NavigationItemSelectedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "MainActivity";
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    PieChart pieChart;
    PieDataSet pieDataSet;
    ArrayList<PieEntry> pieEntries;
    private ButtonAdapter buttonAdapter;
    private RecyclerView recyclerView;
    private List<String> buttonNames;
    private List<Integer> buttonColors;
    private List<Integer> buttonIcons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
         recyclerView = findViewById(R.id.main_activity_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);
        setupRecyclerView();

        // CHART CODE
        pieChart = findViewById(R.id.chart);
        getData();
        setupPieChart();

        List<Float> newValues = new ArrayList<>();
        newValues.add(30.0f);
        newValues.add(70.0f);
        updateChartData(newValues);



        // HAMBURGER MENU CODE
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_menu);

        // Initialize the ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Set the custom NavigationItemSelectedListener
        NavigationItemSelectedListener navigationItemSelectedListener = new NavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    private void getData(){
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(10f, "Questions Seen"));
        pieEntries.add(new PieEntry(90f, "Questions Unseen"));


        ArrayList<Integer> colors = new ArrayList<>();
        PieDataSet dataSet = new PieDataSet(pieEntries, "");
        dataSet.setColors(colors);
        dataSet.setValueFormatter(new PercentFormatter());
    }

    private void setupPieChart() {

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(65,105,225));  // Set the color for the "Blue" slice
        colors.add(Color.rgb(216,21,21));   // Set the color for the "Red" slice

        Description description = pieChart.getDescription();
        description.setText("");

        pieDataSet = new PieDataSet(pieEntries, "");
        float sliceSpace = 4f;
        pieDataSet.setColors(colors);
        pieDataSet.setSliceSpace(sliceSpace);
        pieDataSet.setValueTextSize(9f);
        pieChart.setUsePercentValues(true);

        pieChart.setDrawEntryLabels(false); // Disable drawing entry labels inside the pie chart
        pieChart.getLegend().setEnabled(true); // Enable the legend (key) at the bottom


        pieChart.animateY(1000);

        PieData pieData = new PieData(pieDataSet);
        pieData.setValueFormatter(new PercentFormatter(pieChart));
        pieData.setValueTextSize(9f);

        pieChart.setData(pieData);
        pieChart.invalidate();
    }
    private void updateChartValues(List<Float> values) {
        for (int i = 0; i < values.size(); i++) {
            PieEntry pieEntry = pieEntries.get(i);
            pieEntry.setY(values.get(i));
        }

        pieChart.notifyDataSetChanged();
        pieChart.invalidate();
    }

    // Call this method whenever you want to update the chart with new values
    private void updateChartData(List<Float> newValues) {
        updateChartValues(newValues);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (item.getItemId() == R.id.navMenuLogoutButton) {
            logoutCurrentUser();
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
    private void setupRecyclerView() {
        buttonNames = new ArrayList<>();
        buttonNames.add("Sports");
        buttonNames.add("Cmp Sci");
        buttonNames.add("Animals");
        buttonNames.add("Art");
        buttonNames.add("Fantasy");
        buttonNames.add("History");

        buttonColors = new ArrayList<>();
        buttonColors.add(Color.RED);
        buttonColors.add(Color.BLUE);
        buttonColors.add(Color.GREEN);
        buttonColors.add(Color.BLACK);
        buttonColors.add(Color.MAGENTA);
        buttonColors.add(Color.CYAN);

        buttonIcons = new ArrayList<>();
        buttonIcons.add(R.drawable.main_activity_button_sports_icon);
        buttonIcons.add(R.drawable.main_activity_button_computer_science_icon);
        buttonIcons.add(R.drawable.main_activity_button_animals_icon);
        buttonIcons.add(R.drawable.main_activity_button_art_icon);
        buttonIcons.add(R.drawable.main_activity_button_mythology_icon);
        buttonIcons.add(R.drawable.main_activity_button_history_icon);

        buttonAdapter = new ButtonAdapter(buttonNames, buttonColors, buttonIcons);
        recyclerView.setAdapter(buttonAdapter);

        // Adjust the spanCount and spacing based on your desired layout
        int spanCount = 2; // Number of columns
        int spacing = getResources().getDimensionPixelSize(R.dimen.grid_spacing); // Adjust spacing value as needed

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Add item decoration to set spacing between items
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, true));
    }
//    private void populateDataBase(String fileName) throws IOException, JSONException {
//
//        //Reads file
//        InputStream inputStream = getAssets().open(fileName);
//        int size = inputStream.available();
//        byte[] buffer = new byte[size];
//        inputStream.read(buffer);
//        inputStream.close();
//        String jsonString = new String(buffer, StandardCharsets.UTF_8);
//
//        JSONArray jsonArray = new JSONArray(jsonString);

//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            String category = jsonObject.getString("category");
//            CategoryEnum categoryEnum = CategoryEnum.valueOf(category);
//            String type = jsonObject.getString("type");
//            Boolean typeBool = Boolean.parseBoolean(type);
//            String difficulty = jsonObject.getString("difficulty");
//            DifficultyEnum difficultyEnum = DifficultyEnum.valueOf(difficulty);
//            String question = jsonObject.getString("question");
//            String correctAnswer = jsonObject.getString("correct_answer");
//
//            JSONArray incorrectAnswersJSONArray = new JSONArray(jsonObject.getString("question"));
//            List<String> incorrectAnswersList = new ArrayList();
//
//            for (int j = 0; j < incorrectAnswersJSONArray.length(); j++) {
//                incorrectAnswersList.add(incorrectAnswersJSONArray.getString(j));
//            }
//
//            // Create a new TriviaQuestion object
//            Question triviaQuestion = Question.builder()
//                    .category(categoryEnum)
//                    .type(typeBool)
//                    .difficulty(difficultyEnum)
//                    .question(question)
//                    .correctAnswer(correctAnswer)
//                    .incorrectAnswers(incorrectAnswersList)
//                    .build();
//
//            // Save the TriviaQuestion object to DynamoDB
//            Amplify.DataStore.save(triviaQuestion,
//                    success -> Log.i(TAG, "Saved TriviaQuestion: " + success.item().getId()),
//                    error -> Log.e(TAG, "Failed to save TriviaQuestion: " + error)
//            );
//        }

    private void populateDatabase(String fileName) throws IOException {
        // Read file
        InputStream inputStream = getAssets().open(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        // Use Gson to parse JSON data
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(inputStreamReader, JsonObject.class);
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");

        // Save the Question objects to DynamoDB
        for (JsonElement element : resultsArray) {
            JsonObject questionObject = element.getAsJsonObject();
            String category = questionObject.get("category").getAsString();
            String type = questionObject.get("type").getAsString();
            String difficulty = questionObject.get("difficulty").getAsString();
            String questionText = questionObject.get("question").getAsString();
            String correctAnswer = questionObject.get("correct_answer").getAsString();
            JsonArray incorrectAnswersArray = questionObject.getAsJsonArray("incorrect_answers");
            List<String> incorrectAnswers = new ArrayList<>();
            for (JsonElement incorrectAnswerElement : incorrectAnswersArray) {
                incorrectAnswers.add(incorrectAnswerElement.getAsString());
            }

            String typeValue;
            if (type.equalsIgnoreCase("multiple") || type.equalsIgnoreCase("true")) {
                typeValue = "multiple";
            } else {
                typeValue = "single";
            }

            Question question = Question.builder()
                    .category(CategoryEnum.valueOf(category))
                    .type(typeValue)
                    .difficulty(DifficultyEnum.valueOf(difficulty))
                    .question(questionText)
                    .correctAnswer(correctAnswer)
                    .incorrectAnswers(incorrectAnswers)
                    .build();

            Amplify.DataStore.save(question,
                    success -> Log.i(TAG, "Saved Question: " + success.item().getId()),
                    error -> Log.e(TAG, "Failed to save Question: " + error)
            );
        }

        // Close the streams
        inputStreamReader.close();
        inputStream.close();
    }

    private void logoutCurrentUser() {
        Amplify.Auth.signOut(
                new Consumer<AuthSignOutResult>() {
                    @Override
                    public void accept(@NonNull AuthSignOutResult value) {
                        MainActivity.this.runOnUiThread(() -> {
                            Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                            MainActivity.this.navigateToSignInPage();
                        });
                    }
                }
        );
    }

    private void navigateToSignInPage() {


         Intent intent = new Intent(MainActivity.this, SignInPage.class);
        startActivity(intent);
        finish();
    }

}
