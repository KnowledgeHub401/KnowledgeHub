package com.study.quizzler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.study.quizzler.R;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    private List<String> buttonNames;
    private List<Integer> buttonColors;
    private List<Integer> buttonIcons;

    public ButtonAdapter(List<String> buttonNames, List<Integer> buttonColors, List<Integer> buttonIcons) {
        this.buttonNames = buttonNames;
        this.buttonColors = buttonColors;
        this.buttonIcons = buttonIcons;
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

        holder.button.setText(buttonName);
        holder.button.setBackgroundColor(buttonColor);

        // Set the icon on the left side and center it
        holder.button.setCompoundDrawablesWithIntrinsicBounds(buttonIcon, 0, 0, 0);
        holder.button.setCompoundDrawablePadding(10); // Add padding between icon and text
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