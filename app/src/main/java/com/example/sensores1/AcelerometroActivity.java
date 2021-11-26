package com.example.sensores1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class AcelerometroActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Acelerometro";
    private SensorManager senmgr;
    Sensor acelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        senmgr = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acelerometro = senmgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senmgr.registerListener((SensorEventListener) AcelerometroActivity.this, acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}