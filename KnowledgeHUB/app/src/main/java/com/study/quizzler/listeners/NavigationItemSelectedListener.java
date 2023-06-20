package com.study.quizzler.listeners;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.study.quizzler.MainActivity;
import com.study.quizzler.R;
import com.study.quizzler.activities.AboutUs;
import com.study.quizzler.activities.QuestionPage;
import com.study.quizzler.activities.SettingsPage;

public class NavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;

    public NavigationItemSelectedListener(Context context) {
        this.context = context;
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.navMenuHomeButton) {
            showToast("Home Selected");
            if (context instanceof MainActivity) {
                closeNavigationDrawer();
            } else {
                openMainActivity();
            }
        } else if (itemId == R.id.navMenuAboutUsButton) {
            showToast("About Us Selected");
            openAboutUsPage();
        } else if (itemId == R.id.navMenuAnswersButton) {
            showToast("Questions Page Selected");
            openQuestionsPage();
        } else if (itemId == R.id.navMenuSettingsButton) {
            showToast("Settings Selected");
            openSettingsActivity();
        } else if (itemId == R.id.navMenuLogoutButton) {
            showToast("Logout Selected");
        } else if (itemId == R.id.navMenuRateUsButton) {
            showToast("Rate Us Selected");
        } else if (itemId == R.id.navMenuShareButton) {
            showToast("Share Selected");
        }
        return true;
    }
    private void closeNavigationDrawer() {
        DrawerLayout drawerLayout = ((Activity) context).findViewById(R.id.drawer_layout);
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    private void openMainActivity() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void openSettingsActivity(){
        Intent intent = new Intent(context, SettingsPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void openQuestionsPage(){
        Intent intent = new Intent(context, QuestionPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void openAboutUsPage(){
        Intent intent = new Intent(context, AboutUs.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
}