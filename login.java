package com.example.shiva.she;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class login extends AppCompatActivity {
    DatabaseHelper myDb;
    Button login1;
    EditText phone,passw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login1 = (Button) findViewById(R.id.button2);
        phone = (EditText) findViewById(R.id.log);
        passw = (EditText) findViewById(R.id.pass);
        loginn();

    }


    public void loginn(){
        login1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String ph= phone.getText().toString().trim();
                        String pas = passw.getText().toString().trim();



                        SQLiteDatabase myDb = openOrCreateDatabase("registered.db", MODE_PRIVATE, null);
                        //Cursor cur=db.rawQuery("select * from login_table where phone=? and password=?" ,new String[]{phone,password});
                        String s3 = "select * from login_table where (phone='" + ph + "' and password='" + pas+ "');";
                        Cursor cursor = myDb.rawQuery(s3, null);


                        if (cursor.getCount() > 0) {
                            Intent homeIntent = new Intent(login.this, home.class);
                            startActivity(homeIntent);
                            finish();

                        }


                        else {
                            Toast.makeText(login.this, "Invalid phone or password", Toast.LENGTH_SHORT).show();
                        }
                    }



                });
    }





}

