package blah.blah.weatherforecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather")
    Call<WeatherData> getWeather(@Query("q") String city, @Query("appid") String apiKey);
}

