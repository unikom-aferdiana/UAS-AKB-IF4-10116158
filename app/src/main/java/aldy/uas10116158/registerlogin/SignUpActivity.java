/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:32
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 06:29
 */

package aldy.uas10116158.registerlogin;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import aldy.uas10116158.R;
import aldy.uas10116158.room.AppUserLogin;
import aldy.uas10116158.room.UserLogin;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername, edtPassword;
    private AppUserLogin dbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        Button btnSave = findViewById(R.id.btn_save);

        dbLogin = Room.databaseBuilder(getApplicationContext(), AppUserLogin.class, "user_db")
                .allowMainThreadQueries()
                .build();

        btnSave.setOnClickListener(this);

        List<UserLogin> myList = dbLogin.daoUserLogin().getListUser();

        for (int i = 0; i < myList.size(); i++) {
            Log.e("TESTING", i + myList.get(i).getUsername() + myList.get(i).getPassword());
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save) {
            String u = edtUsername.getText().toString().trim();
            String p = edtPassword.getText().toString().trim();

            final UserLogin user = new UserLogin();
            user.setUsername(u.toLowerCase());
            user.setPassword(p);

            if (u.isEmpty() || p.isEmpty()){
                Toast.makeText(this, "Please fill in the blank.", Toast.LENGTH_LONG).show();
            }else {
                try {
                    dbLogin.daoUserLogin().insertUser(user);
                    Toast.makeText(this, "Username " + u + " saved.", Toast.LENGTH_LONG).show();
                } catch (SQLiteConstraintException e) {
                    Toast.makeText(this, "Username " + u + " does exist.\nPlease input another username.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


}
