package com.cws.pharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inpharma1 extends AppCompatActivity {

    EditText pe1,pe2,pe3;
    Button sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpharma1);

        pe1=(EditText)findViewById(R.id.editText2);
        pe2=(EditText)findViewById(R.id.editText);
        pe3=(EditText)findViewById(R.id.editText3);

        sv=(Button)findViewById(R.id.sv);


        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Student s1=new Student();
            String mname=pe1.getText().toString();
            String quan=pe2.getText().toString();
            String prc=pe3.getText().toString();

                s1.setName(mname);
                s1.setQuantity(quan);
                s1.setPrice(prc);

                MyDbHelper ob = new MyDbHelper(Inpharma1.this, "stud", null, 1);
                ob.addStudent(s1);
                Toast.makeText(Inpharma1.this , "Record save successfully", Toast.LENGTH_SHORT).show();
                pe1.setText(" ");
                pe2.setText(" ");
                pe3.setText(" ");


                Intent i = new Intent(Inpharma1.this,Pharma.class);
                startActivity(i);

            }
        });



            }



    }

