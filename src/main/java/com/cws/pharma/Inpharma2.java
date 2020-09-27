package com.cws.pharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inpharma2 extends AppCompatActivity {
    EditText medname,uppr;
    Button bup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpharma2);

        medname=(EditText)findViewById(R.id.editText4);
        uppr=(EditText)findViewById(R.id.editText5);
        bup=(Button)findViewById(R.id.button3);

        bup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student o=new Student();
                String medinput=medname.getText().toString();
                String prcupd=uppr.getText().toString();
                o.setName(medinput);
                o.setPrice(prcupd);
                MyDbHelper obj2 = new MyDbHelper(Inpharma2.this,"pharm",null,1);
                boolean isUpdate=obj2.UpdateStudent(o);
                if(isUpdate) {
                    Toast.makeText(Inpharma2.this, "Record updated successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Inpharma2.this, "Record not updated", Toast.LENGTH_SHORT).show();

                }

                Intent pharint=new Intent(Inpharma2.this,MainActivity.class);
                startActivity(pharint);
            }


        });


    }
}
