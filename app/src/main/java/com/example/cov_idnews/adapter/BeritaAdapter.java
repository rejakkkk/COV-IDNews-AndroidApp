package com.example.cov_idnews.adapter;

import android.content.Context;
import com.example.cov_idnews.R;
import com.example.cov_idnews.model.Berita;
import com.example.cov_idnews.model.RumahSakit;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Untuk menampilkan data pada database
public class BeritaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Berita> beritaList = new ArrayList<>();

    public void setBeritaList(ArrayList<Berita> beritaList) {
        this.beritaList = beritaList;
    }

    public BeritaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return beritaList.size();
    }

    @Override
    public Object getItem(int i) {
        return beritaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_berita, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Berita berita = (Berita) getItem(i);
        viewHolder.bind(berita);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtJudul, txtTanggal;

        ViewHolder(View view) {
            txtJudul = view.findViewById(R.id.txtJudul);
            txtTanggal = view.findViewById(R.id.txtTanggal);
        }

        void bind(Berita berita) {
            txtJudul.setText(berita.getJudul());
            txtTanggal.setText(berita.getTanggal());
        }
    }
}
