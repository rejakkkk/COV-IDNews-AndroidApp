package com.example.cov_idnews.adapter;

import android.content.Context;
import com.example.cov_idnews.R;
import com.example.cov_idnews.model.RumahSakit;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Untuk menampilkan data pada database
public class RumahSakitAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<RumahSakit> rumahsakitList = new ArrayList<>();

    public void setRumahSakitList(ArrayList<RumahSakit> rumahsakitList) {
        this.rumahsakitList = rumahsakitList;
    }

    public RumahSakitAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return rumahsakitList.size();
    }

    @Override
    public Object getItem(int i) {
        return rumahsakitList.get(i);
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
                    .inflate(R.layout.item_rumahsakit, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        RumahSakit rumahSakit = (RumahSakit) getItem(i);
        viewHolder.bind(rumahSakit);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtNama, txtAlamat;

        ViewHolder(View view) {
            txtNama = view.findViewById(R.id.txtNama);
            txtAlamat = view.findViewById(R.id.txtAlamat);
        }

        void bind(RumahSakit rumahSakit) {
            txtNama.setText(rumahSakit.getNama());
            txtAlamat.setText(rumahSakit.getAlamat());
        }
    }

}
