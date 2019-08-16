/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:30
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:23
 */

package aldy.uas10116158.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import aldy.uas10116158.R;
import aldy.uas10116158.model.Aldy;


public class ProfileFragment extends Fragment {


    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Aldy me = new Aldy();
        me.setNim("10116158");
        me.setNama("Aldy Ferdian Adam");
        me.setKelas("IF-4");
        me.setDesc("\"Ini adalah deskripsi Saya\"");

        ImageView imgProfile = view.findViewById(R.id.imageView);
        TextView tvNim = view.findViewById(R.id.tv_nim);
        TextView tvName = view.findViewById(R.id.tv_name);
        TextView tvDesc = view.findViewById(R.id.tv_desc);
        TextView tvKelas = view.findViewById(R.id.tv_kelas);

        Glide.with(getActivity())
                .load(R.drawable.pas_poto)
                .centerCrop()
                .into(imgProfile);

        tvNim.setText(me.getNim());
        tvName.setText(me.getNama());
        tvDesc.setText(me.getDesc());
        tvKelas.setText(me.getKelas());
    }
}
