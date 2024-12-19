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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
           if(getFname.isEmpty()||getLname.isEmpty()||getPur.isEmpty()||getWhom.isEmpty())
           {
               Toast.makeText(getApplicationContext(),"ALL MUST FILL",Toast.LENGTH_LONG).show();
           }
           else {
               callApi();
           }

        }

        private void callApi() {
            String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
            JSONObject data=new JSONObject();
            try {
                data.put("firstname",getFname);
                data.put("lastname",getLname);
                data.put("purpose",getPur);
                data.put("whomToMeet",getWhom);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            JsonObjectRequest request=new JsonObjectRequest(
                    Request.Method.POST,
                    apiUrl,
                    data,
                    response -> Toast.makeText(getApplicationContext(),"SUCESSFULLY ADDED",Toast.LENGTH_LONG).show(),
                    error -> Toast.makeText(getApplicationContext(),"ERROR OCCURED",Toast.LENGTH_LONG).show()


            );

            RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
            queue.add(request);




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