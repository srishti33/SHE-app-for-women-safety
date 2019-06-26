package com.example.shiva.she;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class complaint extends AppCompatActivity {
Button b,v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        b = (Button) findViewById(R.id.button5);
        v = (Button) findViewById(R.id.button6);
        submit();
        back();
    }

    public void back () {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(complaint.this, home.class);
                startActivity(homeIntent);
                finish();
            }


        });

    }
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
    public void  submit() {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS("+917018081528", "SHE:New complaint registered!");
                Toast.makeText(complaint.this, "Complaint registered", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
