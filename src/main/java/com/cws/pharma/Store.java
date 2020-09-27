package com.cws.pharma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Store extends AppCompatActivity {
    EditText nmst;
    Button stock;
    TextView showst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

    nmst= (EditText) findViewById(R.id.editText7);
    stock=(Button)findViewById(R.id.button5);
    showst=(TextView)findViewById(R.id.textView9);


        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edname;
                edname = nmst.getText().toString();

                MyDbHelper obj = new MyDbHelper(Store.this, "pharmacy", null, 1);
                Student s;
                try {

                    s = obj.findStudent(edname);
                    if (s != null) {
                        String msg = "name :" + s.getName() +
                                "\nquantity :" + s.getQuantity() +
                                "\nprice :" + s.getPrice();
                        showst.setText(msg);

                        Toast.makeText(Store.this, "record found", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Store.this, "No record found", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){Toast.makeText(Store.this, "No record found", Toast.LENGTH_SHORT).show();}
            }
        });


    }
}
