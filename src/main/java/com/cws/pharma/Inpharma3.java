package com.cws.pharma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inpharma3 extends AppCompatActivity {


    EditText ename;
    Button del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inpharma3);

        ename=(EditText) findViewById(R.id.editText6);
        del=findViewById(R.id.button4);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String getdeln=ename.getText().toString();
                MyDbHelper obj = new MyDbHelper(Inpharma3.this, "stud", null, 1);
                obj.deleteStudent(getdeln);
                Toast.makeText(Inpharma3.this , "Record deleted successfully", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
