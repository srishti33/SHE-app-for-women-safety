package com.example.shiva.she;
import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    Button t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        t1 = (Button) findViewById(R.id.button3);
        t2 = (Button) findViewById(R.id.button4);
        //t3 = (TextView) findViewById(R.id.t3);
        // t4 = (TextView) findViewById(R.id.t4);
        // restricted();
        complaint();
        map();
    }

    public void complaint() {
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(home.this, complaint.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }


    public void map() {
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(home.this, map.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }


}