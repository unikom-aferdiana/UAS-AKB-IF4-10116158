/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 18:38
 */

package aldy.uas10116158.teman;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aldy.uas10116158.R;
import aldy.uas10116158.room.Teman;


public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.CardViewViewHolder> {
    private ArrayList<Teman> listTeman = new ArrayList<>();

    public ArrayList<Teman> getListTeman() {
        return listTeman;
    }

    public void setListTeman(ArrayList<Teman> item) {
        listTeman.clear();
        listTeman.addAll(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teman, parent, false);

        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        final Teman f = listTeman.get(position);

        holder.tvNimt.setText(f.getNim());
        holder.tvNamat.setText(f.getNama());
        holder.tvKelast.setText(f.getKelas());
        holder.tvTelepont.setText(f.getTelepon());
        holder.tvEmailt.setText(f.getEmail());
        holder.tvSocialt.setText(f.getSocial());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Teman parce = new Teman();

                parce.setNim(f.getNim());
                parce.setNama(f.getNama());
                parce.setKelas(f.getKelas());
                parce.setTelepon(f.getTelepon());
                parce.setEmail(f.getEmail());
                parce.setSocial(f.getSocial());

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.TEMAN_EXTRA, parce);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTeman.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvNimt, tvNamat, tvKelast, tvTelepont, tvEmailt, tvSocialt;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNimt = itemView.findViewById(R.id.tv_nimt);
            tvNamat = itemView.findViewById(R.id.tv_namat);
            tvKelast = itemView.findViewById(R.id.tv_kelast);
            tvTelepont = itemView.findViewById(R.id.tv_telepont);
            tvEmailt = itemView.findViewById(R.id.tv_emailt);
            tvSocialt = itemView.findViewById(R.id.tv_socialt);
        }
    }
}
