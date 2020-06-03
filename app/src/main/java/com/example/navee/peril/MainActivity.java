package com.example.navee.peril;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView t1;
    private Button b1,b2;
    private EditText et1;
    int value;
    private Handler handler = new Handler();

   // private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);

    }

    public void yes(View v){
        if(!TextUtils.isEmpty(et1.getText().toString())){
            value = Integer.parseInt(et1.getText().toString());
            runnable.run();
        }

    }

    public void no(View v){
        Toast.makeText(this, "Thankyou visit again..", Toast.LENGTH_SHORT).show();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(MainActivity.this,TwoActivity.class);
            handler.postDelayed(this,value);
            startActivity(i);
        }
    };

    private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this,"YOU CAN'T LEAVE ONCE YOU ARE IN...!",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this,TwoActivity.class);
            startActivity(i);
            handler.postDelayed(this,value);
        }
    };

}
