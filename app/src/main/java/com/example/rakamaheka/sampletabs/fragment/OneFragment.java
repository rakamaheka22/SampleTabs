package com.example.rakamaheka.sampletabs.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rakamaheka.sampletabs.DetailActivity;
import com.example.rakamaheka.sampletabs.R;
import com.example.rakamaheka.sampletabs.adapter.RecyclerViewAdapter;
import com.example.rakamaheka.sampletabs.model.ListItem;
import com.example.rakamaheka.sampletabs.util.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {

    private RecyclerView recyclerview;
    public static final String[] judul = new String[]{"Destination 01", "Destination 02",
            "Destination 03", "Destination 04", "Destination 05"};

    public static final String[] desc = new String[]{
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor accumsan tincidunt. Proin eget tortor risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor accumsan tincidunt. Proin eget tortor risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor accumsan tincidunt. Proin eget tortor risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor accumsan tincidunt. Proin eget tortor risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla porttitor accumsan tincidunt. Proin eget tortor risus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula."};

    public static final Integer[] images = {R.drawable.destinations01,
            R.drawable.destinations02, R.drawable.destinations03, R.drawable.destinations04, R.drawable.destinations05};
    private List<ListItem> listItem;

    public OneFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        listItem = new ArrayList<ListItem>();
        for (int i = 0; i < judul.length; i++) {
            ListItem member = new ListItem(judul[i], desc[i], images[i]);
            listItem.add(member);
        }

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listItem, getContext().getApplicationContext());
        recyclerview.setAdapter(adapter);

        recyclerview.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext().getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent i = new Intent(getContext().getApplicationContext(),DetailActivity.class);
                        i.putExtra("JUDUL", judul);
                        i.putExtra("POSITION", position);
                        startActivity(i);
                    }
                }));

        return view;

    }
}