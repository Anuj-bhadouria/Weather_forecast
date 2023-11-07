package blah.blah.weatherforecast;
// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCity;
    private Button buttonGetWeather;
    private WeatherApiService weatherApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCity = findViewById(R.id.editTextCity);
        buttonGetWeather = findViewById(R.id.buttonGetWeather);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApiService = retrofit.create(WeatherApiService.class);

        buttonGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = editTextCity.getText().toString().trim();

                if (!city.isEmpty()) {
                    fetchWeatherData(city);
                } else {
                    showToast("Enter a city, Batman!");
                }
            }
        });
    }

    private void fetchWeatherData(String city) {
        Call<WeatherData> call = weatherApiService.getWeather(city, "53f620ab9126604a6f106eec334febf2"
        );

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    double temperature = response.body().getMain().getTemperature();
                    openWeatherDetailsActivity(temperature);
                } else {
                    showToast("Failed to fetch weather data");
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                showToast("Network error. Please try again.");
            }
        });
    }

    private void openWeatherDetailsActivity(double temperature) {
        Intent intent = new Intent(this, WeatherDetailsActivity.class);
        intent.putExtra("TEMPERATURE", temperature);
        startActivity(intent);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
