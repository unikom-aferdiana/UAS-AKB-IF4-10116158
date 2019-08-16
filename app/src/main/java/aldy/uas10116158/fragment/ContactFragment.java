/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:30
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:24
 */

package aldy.uas10116158.fragment;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import aldy.uas10116158.R;
import aldy.uas10116158.model.Aldy;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements View.OnClickListener {
    private Aldy contact = new Aldy();


    public ContactFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setData();
        Toast.makeText(getActivity(), "TAP on one of them to contact me. :)", Toast.LENGTH_SHORT).show();
        ImageView phone = view.findViewById(R.id.img_phone);
        ImageView email = view.findViewById(R.id.img_email);
        ImageView ig = view.findViewById(R.id.img_ig);
        ImageView twit = view.findViewById(R.id.img_twit);

        ImageView img = view.findViewById(R.id.img_profile);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvNim = view.findViewById(R.id.tv_nim);
        TextView tvKelas = view.findViewById(R.id.tv_kelas);
        TextView tvAge = view.findViewById(R.id.tv_age);
        TextView tvIg = view.findViewById(R.id.tv_ig);
        TextView tvTw = view.findViewById(R.id.tv_twit);
        TextView tvEmail = view.findViewById(R.id.tv_email);
        TextView tvPhone = view.findViewById(R.id.tv_phone);

        Glide.with(getActivity())
                .load(R.drawable.pas_poto)
                .centerCrop()
                .into(img);

        String phoneFormatted = PhoneNumberUtils.formatNumberToE164(
                contact.getPhone(), "ID");

        tvName.setText(contact.getNama());
        tvNim.setText(contact.getNim());
        tvEmail.setText(contact.getEmail());
        tvIg.setText(contact.getIg());
        tvTw.setText(contact.getTwit());
        tvKelas.setText(contact.getKelas());
        tvAge.setText(String.valueOf(contact.getAge()));
        tvPhone.setText(phoneFormatted);

        tvPhone.setOnClickListener(this);
        tvIg.setOnClickListener(this);
        tvEmail.setOnClickListener(this);
        tvTw.setOnClickListener(this);

        phone.setOnClickListener(this);
        email.setOnClickListener(this);
        ig.setOnClickListener(this);
        twit.setOnClickListener(this);
    }

    private void setData() {
        contact.setNama("Aldy Ferdian Adam");
        contact.setAge(21);
        contact.setKelas("IF-4");
        contact.setNim("10116158");
        contact.setIg("exgondrong");
        contact.setTwit("albenooo");
        contact.setEmail("aferdiana@email.unikom.ac.id");
        contact.setPhone("6281222008692");
    }

    void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+" + contact.getPhone()));
        startActivity(intent);
    }

    void openIg() {
        Uri uri = Uri.parse("http://instagram.com/_u/" + contact.getIg());
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/" + contact.getIg())));
        }
    }

    void writeEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + contact.getEmail()));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), "Email app not found.", Toast.LENGTH_LONG).show();
        }
    }

    void openTwit() {
        Uri uriT = Uri.parse("http://twitter.com/" + contact.getTwit());
        Intent twIntent = new Intent(Intent.ACTION_VIEW, uriT);

        twIntent.setPackage("com.twitter.android");

        try {
            startActivity(twIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://twitter.com/" + contact.getTwit())));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_phone:
                dial();
                break;
            case R.id.img_phone:
                dial();
                break;
            case R.id.tv_ig:
                openIg();
                break;
            case R.id.img_ig:
                openIg();
                break;
            case R.id.tv_email:
                writeEmail();
                break;
            case R.id.img_email:
                writeEmail();
                break;
            case R.id.tv_twit:
                openTwit();
                break;
            case R.id.img_twit:
                openTwit();
                break;
        }
    }
}
