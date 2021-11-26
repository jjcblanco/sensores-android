package com.example.sensores1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button infobtn = (Button) findViewById(R.id.button);
        Button acelbtn = (Button) findViewById(R.id.button2);
        Button canvasbtn = (Button) findViewById(R.id.button3);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(info);
            }
        });

        acelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acel = new Intent(MainActivity.this, AcelerometroActivity.class);
                startActivity(acel);
            }
        });

        canvasbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent canvas = new Intent(MainActivity.this, CanvasActivity.class);
                startActivity(canvas);
            }
        });

    }
}