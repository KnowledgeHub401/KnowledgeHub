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
import com.study.quizzler.activities.AboutUsActivity;
import com.study.quizzler.activities.HistoryActivity;
import com.study.quizzler.activities.SettingsPageActivity;
import com.study.quizzler.activities.SignInPageActivity;

public class NavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;

    public NavigationItemSelectedListener(Context context) {
        this.context = context;
    }

    private void ShowToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.navMenuHomeButton) {
            ShowToast("Home Selected");
            if (context instanceof MainActivity) {
                closeNavigationDrawer();
            } else {
                OpenMainActivity();
            }
        } else if (itemId == R.id.navMenuAboutUsButton) {
            ShowToast("About Us Page Selected");
            OpenAboutUsPage();
        } else if (itemId == R.id.navMenuHistoryButton) {
            ShowToast("History Page Selected");
            OpenQuestionsPage();
        } else if (itemId == R.id.navMenuSettingsButton) {
            ShowToast("Settings Page Selected");
            OpenSettingsActivity();
        } else if (itemId == R.id.navMenuLogoutButton) {
            ShowToast("Logout Button Selected");
            Logout();
        } else if (itemId == R.id.navMenuRateUsButton) {
            ShowToast("Rate Us Button Selected");
        } else if (itemId == R.id.navMenuShareButton) {
            ShowToast("Share Button Selected");
        }
        return true;
    }
    private void closeNavigationDrawer() {
        DrawerLayout drawerLayout = ((Activity) context).findViewById(R.id.drawer_layout);
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    private void OpenMainActivity() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void OpenSettingsActivity(){
        Intent intent = new Intent(context, SettingsPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void OpenQuestionsPage(){
        Intent intent = new Intent(context, HistoryActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void OpenAboutUsPage(){
        Intent intent = new Intent(context, AboutUsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
    private void Logout(){
        Intent intent = new Intent(context, SignInPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
        context.startActivity(intent);
        ((Activity) context).finish(); // Finish the current activity
    }
}