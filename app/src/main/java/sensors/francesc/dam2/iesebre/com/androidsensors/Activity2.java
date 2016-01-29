package sensors.francesc.dam2.iesebre.com.androidsensors;

import android.content.Intent;
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


public class Activity2 extends AppCompatActivity implements SensorEventListener {
    private SensorManager mgr;
    private Sensor proximity;
    private TextView text;
    private StringBuilder msg = new StringBuilder(2048);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        proximity = mgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        text = (TextView) findViewById(R.id.text);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        navbar();

    }
    @Override
    protected void onResume() {
        mgr.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

    @Override
    protected void onPause() {
        mgr.unregisterListener(this, proximity);
        super.onPause();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // ignore
    }

    public void onSensorChanged(SensorEvent event) {
        text.setText("Got a sensor event: " + event.values[0] + " centimeters\n");
        text.invalidate();
    }

    public void navbar(){
        final Button accelerometer =(Button)findViewById(R.id.btn1);
        accelerometer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act1 = new Intent(view.getContext(),MainActivity.class);
                finish();
                startActivity(act1);
            }
        });

        final Button proximity =(Button)findViewById(R.id.btn2);
        proximity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(),Activity2.class);
                finish();
                startActivity(act2);
            }
        });

        final Button orientation =(Button)findViewById(R.id.btn3);
        orientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act3 = new Intent(view.getContext(),Activity3.class);
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
}
