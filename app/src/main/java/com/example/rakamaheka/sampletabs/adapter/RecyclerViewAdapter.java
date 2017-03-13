package com.example.rakamaheka.sampletabs.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rakamaheka.sampletabs.R;
import com.example.rakamaheka.sampletabs.model.ListItem;

import java.util.List;

/**
 * Created by RakaWorld on 18/11/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder> {

    private List<ListItem> listItem;
    private Context context;

    public RecyclerViewAdapter(List<ListItem> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView judul;
        private TextView desc;
        private ImageView image;

        public ListViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            judul = (TextView) itemView.findViewById(R.id.judul_card);
            desc = (TextView) itemView.findViewById(R.id.desc_card);
            image = (ImageView) itemView.findViewById(R.id.image_card);
        }
    }

    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        listViewHolder.judul.setText(listItem.get(i).getJudul());
        listViewHolder.desc.setText(listItem.get(i).getDesc());
        listViewHolder.image.setImageResource(listItem.get(i).getImage());
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_adapter, viewGroup, false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
}
