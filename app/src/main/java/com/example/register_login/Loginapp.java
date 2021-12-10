package com.example.register_login;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginapp extends AppCompatActivity {
    Database md;
    int s,sw;
    EditText edi;
    EditText edp;
    Button bu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginapp);
        md= new Database(this,null,null,1);
        edi =(EditText) findViewById(R.id.edi);
        edp=(EditText) findViewById(R.id.edp);
        bu=(Button) findViewById(R.id.bu);
        bu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean q=md.checkusername(edi.getText().toString());
                        boolean e=md.checkpassword(edp.getText().toString());
                        if(q==true ) {
                            s = 0;
                        }
                        if(q==false){
                            s=1;
                        }
                        if(e==true ) {
                            sw = 0;
                        }
                        if(e==false){
                            sw=1;
                        }
                        if (s+sw==0) {

                            Intent w = new Intent(Loginapp.this,logedin.class);
                            startActivity(w);
                        }

                        else
                            Toast.makeText(Loginapp.this, "NOT found in database", Toast.LENGTH_LONG).show();

                    }
                }
        );

    }
}