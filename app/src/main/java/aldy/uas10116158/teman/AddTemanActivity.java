/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 18:34
 */

package aldy.uas10116158.teman;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import aldy.uas10116158.R;
import aldy.uas10116158.room.Teman;
import aldy.uas10116158.room.TemanDao;
import aldy.uas10116158.room.TemanDb;

public class AddTemanActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtNim, edtNama, edtKelas, edtTelepon, edtEmail, edtSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teman);

        Button btnSave = findViewById(R.id.btn_save);
        Button btnBack = findViewById(R.id.btn_back);

        edtNim = findViewById(R.id.edt_nim);
        edtNama = findViewById(R.id.edt_nama);
        edtKelas = findViewById(R.id.edt_kelas);
        edtTelepon = findViewById(R.id.edt_telepon);
        edtEmail = findViewById(R.id.edt_email);
        edtSocial = findViewById(R.id.edt_username);


        btnSave.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                try {
                    addItem();
                } catch (SQLiteConstraintException e) {
                    Toast.makeText(this, "NIM does exist, plesae change.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }

    private void addItem() {
        String nim = edtNim.getText().toString().trim();
        String nama = edtNama.getText().toString().trim();
        String kelas = edtKelas.getText().toString().trim();
        String telepon = edtTelepon.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String social = edtSocial.getText().toString().trim();

        if (nim.isEmpty() || nama.isEmpty() || kelas.isEmpty() || telepon.isEmpty() ||
                email.isEmpty() || social.isEmpty()) {
            Toast.makeText(this, "Please fill in the blank.", Toast.LENGTH_LONG).show();
        } else {
            Teman teman = new Teman();
            teman.setNim(nim);
            teman.setNama(nama);
            teman.setKelas(kelas);
            teman.setTelepon(telepon);
            teman.setEmail(email);
            teman.setSocial(social);
            TemanDb ud = TemanDb.getAppDatabase(this);
            TemanDao dao = ud.temanDao();
            dao.insert(teman);
            Toast.makeText(this, "Data saved.", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
