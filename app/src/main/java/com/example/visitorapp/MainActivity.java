package com.example.visitorapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1,b2;
    String getFname,getLname,getPur,getWhom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    e1=(EditText) findViewById(R.id.fn);
    e2=(EditText) findViewById(R.id.ln);
    e3=(EditText) findViewById(R.id.pr);
    e4=(EditText) findViewById(R.id.wm);
    b1=(Button) findViewById(R.id.subbtn);
    b2=(Button) findViewById(R.id.got);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFname=e1.getText().toString();
            getLname=e2.getText().toString();
            getPur=e3.getText().toString();
            getWhom=e4.getText().toString();
            Toast.makeText(getApplicationContext(),getFname+" "+getLname+" "+getPur+" "+getWhom+" ",Toast.LENGTH_LONG).show();

        }

    });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent obj=new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(obj);
        }
    });
    }
}