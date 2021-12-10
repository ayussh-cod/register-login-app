package com.example.register_login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Database mdb;
    EditText e;
    EditText ed ;
    ImageView img;
    TextView te;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb= new Database(this,null,null,1);

        e= (EditText) findViewById(R.id.e);
        ed=(EditText) findViewById(R.id.ed);
        button= (Button) findViewById(R.id.button);
        te= (TextView) findViewById(R.id.te);
        img = (ImageView) findViewById(R.id.imageView);
        button.setEnabled(true);
        button.setBackgroundColor(Color.GREEN);
        Toast.makeText(this,"Button is dissabled",Toast.LENGTH_LONG).show();
        addall();
        img.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent u = new Intent(MainActivity.this,Loginapp.class);
                        startActivity(u);
                    }
                }
        );
    }
    public void addall(){


        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean t = mdb.add(e.getText().toString(),ed.getText().toString());
                        if(t=false){
                            Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();

                        }
                        if(t=true) {
                            Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_LONG).show();
                            Intent i= new Intent(MainActivity.this,Loginapp.class);
                            startActivity(i);
                        }


                    }
                }
        );

    }

}