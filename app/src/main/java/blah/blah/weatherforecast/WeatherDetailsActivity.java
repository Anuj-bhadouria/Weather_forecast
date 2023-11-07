package blah.blah.weatherforecast;
// WeatherDetailsActivity.java
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherDetailsActivity extends AppCompatActivity {

    private TextView textViewTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        textViewTemperature = findViewById(R.id.textViewTemperature);

        double temperature = getIntent().getDoubleExtra("TEMPERATURE", 0);
        displayTemperature(temperature);
    }

    private void displayTemperature(double temperature) {
        String temperatureText = String.format("Temperature: %.2f°C", temperature);
        textViewTemperature.setText(temperatureText);
    }
}
