package com.study.quizzler.activities.animations;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;

public class SliceScaleAnimator implements ValueAnimator.AnimatorUpdateListener {

    private PieChart pieChart;

    public SliceScaleAnimator(PieChart pieChart) {
        this.pieChart = pieChart;
    }

    public void animateSliceScale(int sliceIndex, float scaleFactor) {
        Entry entry = pieChart.getData().getDataSet().getEntryForIndex(sliceIndex);
        float originalAngle = entry.getY(); // Original slice angle


        ValueAnimator animator = ValueAnimator.ofFloat(0f, scaleFactor);
        animator.setDuration(500);
        animator.setInterpolator(new DecelerateInterpolator());

        animator.addUpdateListener(animation -> {
            float scale = (float) animation.getAnimatedValue();
            float newAngle = originalAngle * scale;
            entry.setY(newAngle);
            pieChart.notifyDataSetChanged();
            pieChart.invalidate();
        });

        animator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        // Optional: Handle animation update if needed
    }
}