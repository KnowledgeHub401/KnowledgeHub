package com.study.quizzler.listeners;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.study.quizzler.R;

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
        } else if (itemId == R.id.navMenuAboutUsButton) {
            showToast("About Us Selected");
        } else if (itemId == R.id.navMenuAnswersButton) {
            showToast("Questions Page Selected");
        } else if (itemId == R.id.navMenuSettingsButton) {
            showToast("Settings Selected");
        } else if (itemId == R.id.navMenuLogoutButton) {
            showToast("Logout Selected");
        } else if (itemId == R.id.navMenuRateUsButton) {
            showToast("Rate Us Selected");
        } else if (itemId == R.id.navMenuShareButton) {
            showToast("Share Selected");
        }

        return true;
    }
}