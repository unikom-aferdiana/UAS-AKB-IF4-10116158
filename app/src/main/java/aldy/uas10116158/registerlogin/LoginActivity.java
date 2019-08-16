/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:32
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 06:18
 */

package aldy.uas10116158.registerlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import aldy.uas10116158.MainActivity;
import aldy.uas10116158.R;
import aldy.uas10116158.room.AppUserLogin;
import aldy.uas10116158.room.UserLogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnSignup;
    private AppUserLogin dbLogin;
    private UserLogin user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSignup = findViewById(R.id.btn_signup);

        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);

        dbLogin = Room.databaseBuilder(getApplicationContext(), AppUserLogin.class, "user_db")
                .allowMainThreadQueries()
                .build();

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                String us = edtUsername.getText().toString();
                String pas = edtPassword.getText().toString();
                dbLogin.daoUserLogin().findByUsername(us,pas);
                if (dbLogin.daoUserLogin().findByUsername(us,pas) == null){
                    Toast.makeText(this, "username and password are doesn't match.", Toast.LENGTH_LONG).show();
                }else{
                    SharedPreferences mSharedPreferences = getSharedPreferences(MainActivity.PREF_KEY, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putString(MainActivity.USERNAME_KEY, us);
                    editor.putString(MainActivity.PASSWORD_KEY, pas);
                    editor.commit();
                    Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
                    finish();
                    startActivity(toMain);
                }
                break;
            case R.id.btn_signup:
                Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signup);
                break;
        }
    }
}
