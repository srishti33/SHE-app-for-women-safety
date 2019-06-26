package com.example.shiva.she;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;


public class main extends AppCompatActivity {

        DatabaseHelper myDb;
        EditText t1,t2, t3, t4,t5,t6;
        Button button;
        TextView t;

        private AwesomeValidation awesomeValidation;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            myDb = new DatabaseHelper(this);

            awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
            t1 = (EditText) findViewById(R.id.t1);
            t2 = (EditText) findViewById(R.id.t2);
            t3 = (EditText) findViewById(R.id.t3);
            t4 = (EditText) findViewById(R.id.t4);
            t5 = (EditText) findViewById(R.id.t5);
            t6 = (EditText) findViewById(R.id.t6);

            button = (Button) findViewById(R.id.button);
            t = (TextView) findViewById(R.id.txt);

            awesomeValidation.addValidation(this, R.id.t6, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
            awesomeValidation.addValidation(this, R.id.t1, "^[2-9]{2}[0-9]{8}$", R.string.aadhar);
            awesomeValidation.addValidation(this, R.id.t2, "^[2-9]{2}[0-9]{8}$", R.string.phoneerror);
            awesomeValidation.addValidation(this, R.id.t3, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);
            awesomeValidation.addValidation(this, R.id.t4, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderr);
            awesomeValidation.addValidation(this, R.id.t5, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.addr);
            register();
            login();

        }

        public void register () {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInserted = myDb.insertData(t6.getText().toString(),
                            t1.getText().toString(), t2.getText().toString(), t3.getText().toString(),t4.getText().toString(),t5.getText().toString());
                    if(isInserted==true){
                    if (awesomeValidation.validate() && (t3.getText().toString().equals(t4.getText().toString()))) {
                        Toast.makeText(main.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                    }} else {
                        Toast.makeText(main.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }

                }
            })
            ;


        }
        public void login () {
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent homeIntent = new Intent(main.this, login.class);
                    startActivity(homeIntent);
                    finish();
                }


            });

        }

    }
