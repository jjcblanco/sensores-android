package com.example.sensores1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ShapeDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.Display;
import android.view.View;

public class CanvasActivity extends AppCompatActivity implements SensorEventListener {
    /** Called when the activity is first created. */
    CustomDrawableView mCustomDrawableView = null;
    ShapeDrawable mDrawable = new ShapeDrawable();
    public static int x;
    public static int y;
    private Bitmap mBitmap;
    private Bitmap mWood;
    private SensorManager sensorManager = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        // Get a reference to a SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mCustomDrawableView = new CustomDrawableView(this);
        setContentView(mCustomDrawableView);
        // setContentView(R.layout.main);

    }

    // This method will update the UI on new sensor events
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        {
            if(sensorEvent.sensor.getType() == Sensor.TYPE_GYROSCOPE)
            {
                Log.d("gisroscopox",String.valueOf(sensorEvent.values[1]));
                Log.d("gisroscopoy",String.valueOf(sensorEvent.values[2]));
            }
            if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                Display display = getWindowManager().getDefaultDisplay();
                int xmax = display.getWidth();
                int ymax = display.getHeight();

                x = (int) Math.pow(sensorEvent.values[1], 2)*2;
                y = (int) Math.pow(sensorEvent.values[2], 2)*2;
                if (x > xmax) {
                    x = xmax;
                } else if (x < -xmax) {
                    x = -xmax;
                }
                if (y > ymax) {
                    y = ymax;
                } else if (y < -ymax) {
                    y = -ymax;
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // Register this class as a listener for the accelerometer sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
        // ...and the orientation sensor
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop()
    {
        // Unregister the listener
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    public class CustomDrawableView extends View
    {
        public CustomDrawableView(Context context)
        {
            super(context);
            Bitmap ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
            final int dstWidth = 50;
            final int dstHeight = 50;
            mBitmap = Bitmap.createScaledBitmap(ball, dstWidth, dstHeight, true);
            mWood = BitmapFactory.decodeResource(getResources(), R.drawable.wood01);
        }

        protected void onDraw(Canvas canvas)
        {
            final Bitmap bitmap = mBitmap;
            canvas.drawBitmap(mWood, 0, 0, null);
            canvas.drawBitmap(bitmap, x, y, null);
            invalidate();
        }
    }
}
/*public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
    }
}


 */