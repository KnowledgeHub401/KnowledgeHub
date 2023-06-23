package com.study.quizzler.adapters;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.study.quizzler.R;
import com.study.quizzler.activities.QuizActivity;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private List<String> buttonNames;
    private List<Integer> buttonColors;
    private List<Integer> buttonIcons;
    private List<String> buttonValues;

    public ButtonAdapter(List<String> buttonNames, List<Integer> buttonColors, List<Integer> buttonIcons, List<String> buttonValues) {
        this.buttonNames = buttonNames;
        this.buttonColors = buttonColors;
        this.buttonIcons = buttonIcons;
        this.buttonValues = buttonValues;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_button_item, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        String buttonName = buttonNames.get(position);
        int buttonColor = buttonColors.get(position);
        int buttonIcon = buttonIcons.get(position);
        String buttonValue = buttonValues.get(position);


        holder.button.setText(buttonName);
        holder.button.setBackgroundColor(buttonColor);


        // Set the icon on the left side and center it
        holder.button.setCompoundDrawablesWithIntrinsicBounds(buttonIcon, 0, 0, 0);
        holder.button.setCompoundDrawablePadding(10); // Add padding between icon and text

        // Set the button's gravity to center
        holder.button.setGravity(Gravity.CENTER);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the button click event here
                // You can start a new activity or perform any other action based on the button clicked

                Intent intent = new Intent(view.getContext(), QuizActivity.class);
                intent.putExtra("selected_category", buttonValue);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buttonNames.size();
    }

    static class ButtonViewHolder extends RecyclerView.ViewHolder {

        Button button;

        ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.main_activity_recycler_view_button);
        }
    }
}