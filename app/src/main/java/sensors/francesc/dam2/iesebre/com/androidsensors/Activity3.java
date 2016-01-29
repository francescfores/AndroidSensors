package sensors.francesc.dam2.iesebre.com.androidsensors;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Activity3 extends AppCompatActivity implements SensorEventListener {
    private TextView txtView1;
    private TextView txtView2;
    private TextView txtView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtView1 = (TextView) findViewById(R.id.txtView1);
        txtView2 = (TextView) findViewById(R.id.txtView2);
        txtView3 = (TextView) findViewById(R.id.txtView3);


        SensorManager sensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(new CustomOrientationListener(), sensor,
                SensorManager.SENSOR_DELAY_GAME);

        navbar();


    }

    public void navbar(){
        final Button accelerometer =(Button)findViewById(R.id.btn1);
        accelerometer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act1 = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(act1);
            }
        });

        final Button proximity =(Button)findViewById(R.id.btn2);
        proximity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(), Activity2.class);
                finish();
                startActivity(act2);
            }
        });

        final Button orientation =(Button)findViewById(R.id.btn3);
        orientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3 = new Intent(view.getContext(), Activity3.class);
                finish();
                startActivity(act3);
            }
        });
        final Button temperature =(Button)findViewById(R.id.btn4);
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act4 = new Intent(view.getContext(),Activity4.class);
                finish();
                startActivity(act4);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    class CustomOrientationListener implements SensorEventListener {

        public CustomOrientationListener() {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values;
            if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
                values = event.values;
                txtView1.setText(""+values[0]);
                txtView1.invalidate();
                txtView2.setText("" + values[1]);
                txtView1.invalidate();
                txtView3.setText(""+values[2]);
            }

        }
    }
}
