package sensors.francesc.dam2.iesebre.com.androidsensors;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView title,tv,tv1,tv2;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenim el servei de sensors
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //obtenim el sensor acceleròmetre
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        layout = (LinearLayout)findViewById(R.id.relative);

        title=(TextView)findViewById(R.id.name);
        tv=(TextView)findViewById(R.id.xval);
        tv1=(TextView)findViewById(R.id.yval);
        tv2=(TextView)findViewById(R.id.zval);
        navbar();

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
    @Override
    public final void onSensorChanged(SensorEvent event)
    {
        //Retornem el valor del acceleròmetre
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        tv.setText("X axis" +"\t\t"+x);
        tv1.setText("Y axis" + "\t\t" + y);
        tv2.setText("Z axis" + "\t\t" + z);
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
