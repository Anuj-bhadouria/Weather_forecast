package blah.blah.weatherforecast;

// WeatherData.java
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {
    @SerializedName("main")
    public Main main;

    @SerializedName("weather")
    public List<Weather> weather;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("visibility")
    public int visibility;

    @SerializedName("dt")
    public long timestamp;

    @SerializedName("sys")
    public Sys sys;

    @SerializedName("name")
    public String cityName;

    public class Main {
        @SerializedName("temp")
        public float temperature;

        @SerializedName("temp_min")
        public float tempMin;

        @SerializedName("temp_max")
        public float tempMax;

        @SerializedName("pressure")
        public float pressure;

        @SerializedName("humidity")
        public int humidity;
    }

    public class Weather {
        @SerializedName("main")
        public String mainCondition;

        @SerializedName("description")
        public String description;

        @SerializedName("icon")
        public String iconCode;
    }

    public class Wind {
        @SerializedName("speed")
        public float speed;

        @SerializedName("deg")
        public float degree;
    }

    public class Clouds {
        @SerializedName("all")
        public int cloudiness;
    }

    public class Sys {
        @SerializedName("country")
        public String country;
    }
}
