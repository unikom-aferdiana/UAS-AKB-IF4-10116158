/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 13/08/19 20:39
 */

package aldy.uas10116158;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import aldy.uas10116158.fragment.ContactFragment;
import aldy.uas10116158.fragment.FriendsFragment;
import aldy.uas10116158.fragment.ProfileFragment;
import aldy.uas10116158.registerlogin.LoginActivity;


public class MainActivity extends AppCompatActivity {
    public static final String PREF_KEY = "pref_key";
    public static final String USERNAME_KEY = "username_key";
    public static final String PASSWORD_KEY = "password_key";
    private TextView mTextMessage;
    private boolean doubleBackToExitPressedOnce = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).commit();
                    return true;
                case R.id.navigation_contact:
                    fragment = new ContactFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).commit();
                    return true;
                case R.id.navigation_friends:
                    fragment = new FriendsFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to logout", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
                logout();
            }
        }, 2000);
    }

    private void logout() {
        SharedPreferences.Editor editor = getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE).edit();
        editor.remove(USERNAME_KEY);
        editor.remove(PASSWORD_KEY);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.three_dots_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            logout();
            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            finish();
            startActivity(login);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) navView.setSelectedItemId(R.id.navigation_profile);
    }

}