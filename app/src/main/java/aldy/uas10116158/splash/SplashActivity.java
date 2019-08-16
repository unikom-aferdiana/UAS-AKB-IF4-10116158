/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:31
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 13/08/19 20:39
 */

package aldy.uas10116158.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import aldy.uas10116158.viewpager.IntroActivity;
import aldy.uas10116158.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent move = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(move);
                finish();
            }
        }, 2000);
    }
}
