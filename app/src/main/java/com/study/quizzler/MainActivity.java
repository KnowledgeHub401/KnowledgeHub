package com.study.quizzler;

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
import com.study.quizzler.listeners.NavigationItemSelectedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity  {

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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
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
        colors.add(Color.GREEN);  // Set the color for the "Green" slice
        colors.add(Color.RED);   // Set the color for the "Blue" slice
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
        buttonColors.add(Color.YELLOW);
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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

}