package obecerra.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;





import obecerra.R;

public class Main extends Activity {
    TextView textLight;
    SensorManager sensorManager;
    Sensor sensor;
    LinearLayout mScreen;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        textLight = (TextView) findViewById(R.id.textLight);
    }

    public void onResume() {
        super.onResume();
        sensorManager.registerListener(lightListener, sensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(lightListener);
    }

    public SensorEventListener lightListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) { }

        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];

            textLight.setText((int)x + " lux");



            mScreen = (LinearLayout) findViewById(R.id.myScreen);



            if(x<=0)

            {


                mScreen.setBackgroundColor(Color.rgb(0,82,33));




            }

            else if(x<=51)

            {

                mScreen.setBackgroundColor(Color.rgb(105,155,103));
            }


            else if(x<=80)

            {

                mScreen.setBackgroundColor(Color.rgb(125,164,120));
            }


            else if(x<=130)

            {

                mScreen.setBackgroundColor(Color.rgb(153,184,147));
            }


            else if(x<=180)

            {

                mScreen.setBackgroundColor(Color.rgb(204,235,197));
            }


            else if(x<=220)

            {

                mScreen.setBackgroundColor(Color.rgb(230,245,226));
            }



























        }
    };
}