package com.example.rakamaheka.sampletabs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    CheckBox ya1, ya2, tidak1, tidak2;
    Button button;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ya1 = (CheckBox) findViewById(R.id.ya1);
        ya2 = (CheckBox) findViewById(R.id.ya2);
        tidak1 = (CheckBox) findViewById(R.id.tidak1);
        tidak2 = (CheckBox) findViewById(R.id.tidak2);
        button = (Button) findViewById(R.id.button);

        //jawaban yang bener
        ya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahPoint();
            }
        });
        //jawaban yang bener
        tidak2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahPoint();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ya1.isChecked() && tidak1.isChecked() || ya2.isChecked() && tidak2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Pilih salah satu jawaban", Toast.LENGTH_SHORT).show();
                }else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(new ContextThemeWrapper(Main5Activity.this, R.style.myDialog));
                    dialog.setMessage("Pointmu adalah: "+total);
                    dialog.setPositiveButton("COBA LAGI",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            total = 0;
                            ya1.setChecked(false);
                            tidak1.setChecked(false);
                            ya2.setChecked(false);
                            tidak2.setChecked(false);

                        }
                    });
                    dialog.setCancelable(false);
                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
                }

            }
        });

    }

    private void tambahPoint(){total = total + 50;}
}
