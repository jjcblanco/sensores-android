package com.example.sensores1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private SensorManager senmgr;
    private TextView txtlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        senmgr = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        txtlist = (TextView)findViewById(R.id.sensorsList);
        List<Sensor> sensorList = senmgr.getSensorList(Sensor.TYPE_ALL);
        StringBuilder strBuilder = new StringBuilder();

        for(Sensor s: sensorList){
            strBuilder.append(s.getName()+"\n");
        }
        txtlist.setVisibility(View.VISIBLE);
        txtlist.setText(strBuilder);
    }
}