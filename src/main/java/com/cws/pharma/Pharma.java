package com.cws.pharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pharma extends AppCompatActivity {
Button prof,upro,dpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharma);

        prof=(Button)findViewById(R.id.pr);
        upro=(Button)findViewById(R.id.up);
        dpro=(Button)findViewById(R.id.dp);

        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Pharma.this,Inpharma1.class);
                startActivity(i);

            }
        });


        upro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Pharma.this,Inpharma2.class);
                startActivity(j);

            }
        });
        dpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Pharma.this,Inpharma3.class);
                startActivity(k);

            }
        });





    }
}
