/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:30
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:24
 */

package aldy.uas10116158.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import aldy.uas10116158.R;
import aldy.uas10116158.room.Teman;
import aldy.uas10116158.room.TemanDao;
import aldy.uas10116158.room.TemanDb;
import aldy.uas10116158.teman.AddTemanActivity;
import aldy.uas10116158.teman.TemanAdapter;


public class FriendsFragment extends Fragment {
    public static boolean allowRefresh;
    private TemanAdapter adapter = new TemanAdapter();
    private ArrayList<Teman> daftarTeman;


    public FriendsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_friends, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = view.findViewById(R.id.btn_fab);

        daftarTeman = new ArrayList<>();

        TemanDb tmnDb = TemanDb.getAppDatabase(getActivity());
        TemanDao dao = tmnDb.temanDao();

        daftarTeman.addAll(dao.getAllUsers());

        RecyclerView rvTeman;
        rvTeman = getActivity().findViewById(R.id.rv_friends);
        rvTeman.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTeman.setAdapter(adapter);
        adapter.setListTeman(daftarTeman);
        adapter.notifyDataSetChanged();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTeman();
                allowRefresh = true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (allowRefresh) {
            allowRefresh = false;
            getFragmentManager().beginTransaction().detach(this).attach(this).commit();
        }
    }

    private void addTeman() {
        Intent add = new Intent(getActivity(), AddTemanActivity.class);
        startActivity(add);
    }
}
