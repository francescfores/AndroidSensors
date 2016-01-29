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

public class Activity4 extends AppCompatActivity implements SensorEventListener {

    TextView textTEMPERATURE_available, textTEMPERATURE_reading;
    TextView textAMBIENT_TEMPERATURE_available, textAMBIENT_TEMPERATURE_reading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textTEMPERATURE_available
                = (TextView)findViewById(R.id.TEMPERATURE_available);
        textTEMPERATURE_reading
                = (TextView)findViewById(R.id.TEMPERATURE_reading);
        textAMBIENT_TEMPERATURE_available
                = (TextView)findViewById(R.id.AMBIENT_TEMPERATURE_available);
        textAMBIENT_TEMPERATURE_reading
                = (TextView)findViewById(R.id.AMBIENT_TEMPERATURE_reading);

        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        Sensor TemperatureSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
        if(TemperatureSensor != null){
            textTEMPERATURE_available.setText("Sensor TYPE TEMPERATURE available");
            mySensorManager.registerListener(
                    TemperatureSensorListener,
                    TemperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            textTEMPERATURE_available.setText("Sensor TYPE TEMPERATURE not available");
        }

        Sensor AmbientTemperatureSensor
                = mySensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(AmbientTemperatureSensor != null){
            textAMBIENT_TEMPERATURE_available.setText("Sensor TYPE AMBIENT TEMPERATURE available");
            mySensorManager.registerListener(
                    AmbientTemperatureSensorListener,
                    AmbientTemperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            textAMBIENT_TEMPERATURE_available.setText("Sensor TYPE AMBIENT TEMPERATURE not available");
        }

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
                Intent act4 = new Intent(view.getContext(), Activity4.class);
                finish();
                startActivity(act4);
            }
        });
    }


    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onSensorChanged(SensorEvent event) {

    }

    private final SensorEventListener TemperatureSensorListener
            = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_TEMPERATURE){
                textTEMPERATURE_reading.setText("TEMPERATURE: " + event.values[0]);
            }
        }

    };

    private final SensorEventListener AmbientTemperatureSensorListener
            = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
                textAMBIENT_TEMPERATURE_reading.setText("AMBIENT TEMPERATURE: " + event.values[0]);
            }
        }

    };
}
