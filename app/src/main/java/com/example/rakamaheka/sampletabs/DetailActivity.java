package com.example.rakamaheka.sampletabs;

import android.app.ActionBar;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    String[] judul;
    int position;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        judul = i.getStringArrayExtra("JUDUL");
        position = i.getExtras().getInt("POSITION");

        setTitle(judul[position]);

        imageView = (ImageView) findViewById(R.id.image);
        if(judul[position].equals("Destination 01")){
            imageView.setImageResource(R.drawable.destinations01);
        }else if(judul[position].equals("Destination 02")){
            imageView.setImageResource(R.drawable.destinations02);
        }else if(judul[position].equals("Destination 03")){
            imageView.setImageResource(R.drawable.destinations03);
        }else if(judul[position].equals("Destination 04")){
            imageView.setImageResource(R.drawable.destinations04);
        }else if(judul[position].equals("Destination 05")){
            imageView.setImageResource(R.drawable.destinations05);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return false;
    }
}
