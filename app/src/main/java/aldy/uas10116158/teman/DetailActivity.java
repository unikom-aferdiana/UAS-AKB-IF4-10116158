/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 20:52
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 20:48
 */

package aldy.uas10116158.teman;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import aldy.uas10116158.R;
import aldy.uas10116158.fragment.FriendsFragment;
import aldy.uas10116158.room.Teman;
import aldy.uas10116158.room.TemanDao;
import aldy.uas10116158.room.TemanDb;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String TEMAN_EXTRA = "teman_extra";
    private EditText edtNim, edtNama, edtKelas, edtTelepon, edtEmail, edtSocial;
    private TemanDb tDb = TemanDb.getAppDatabase(this);
    private TemanDao tDao = tDb.temanDao();
    private Teman F = new Teman();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        F = getIntent().getParcelableExtra(TEMAN_EXTRA);

        Button btnUpdate = findViewById(R.id.btn_update);
        Button btnDelete = findViewById(R.id.btn_delete);
        Button btnBack = findViewById(R.id.btn_back);

        edtNim = findViewById(R.id.edt_nim);
        edtNama = findViewById(R.id.edt_nama);
        edtKelas = findViewById(R.id.edt_kelas);
        edtTelepon = findViewById(R.id.edt_telepon);
        edtEmail = findViewById(R.id.edt_email);
        edtSocial = findViewById(R.id.edt_username);

        edtNim.setText(F.getNim());
        edtNama.setText(F.getNama());
        edtKelas.setText(F.getKelas());
        edtEmail.setText(F.getEmail());
        edtTelepon.setText(F.getTelepon());
        edtSocial.setText(F.getSocial());

        edtNim.setEnabled(false);

        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    void updte(){
        F = getIntent().getParcelableExtra(TEMAN_EXTRA);
        Teman object = new Teman();

        String nim = edtNim.getText().toString().trim();
        String nama = edtNama.getText().toString().trim();
        String kelas = edtKelas.getText().toString().trim();
        String telepon = edtTelepon.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String social = edtSocial.getText().toString().trim();

        if (nim.isEmpty() || nama.isEmpty() || kelas.isEmpty() || telepon.isEmpty() ||
                email.isEmpty() || social.isEmpty()) {
            Toast.makeText(this, "Please fill in the blank.", Toast.LENGTH_LONG).show();
        }else {
            object.setNim(nim);
            object.setNama(nama);
            object.setKelas(kelas);
            object.setTelepon(telepon);
            object.setEmail(email);
            object.setSocial(social);

            tDao.update(object);
            Toast.makeText(this, "NIM " + F.getNim() + " updated.", Toast.LENGTH_LONG).show();
            FriendsFragment.allowRefresh = true;
            finish();
        }
    }

    void delete() {
        F = getIntent().getParcelableExtra(TEMAN_EXTRA);
        Teman object = new Teman();

        object.setNim(F.getNim());
        object.setNama(F.getNama());
        object.setKelas(F.getKelas());
        object.setTelepon(F.getTelepon());
        object.setEmail(F.getEmail());
        object.setSocial(F.getSocial());

        tDao.delete(object);
        Toast.makeText(this, "NIM " + F.getNim() + " deleted.", Toast.LENGTH_LONG).show();
        FriendsFragment.allowRefresh = true;
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                updte();
                break;
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_delete:
                delete();
                break;
        }
    }
}
