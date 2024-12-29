package zeev.fraiman.weatherreportwithapi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

import coil.ImageLoader;
import coil.request.ImageRequest;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class WeatherDetailsActivity extends AppCompatActivity {

    private TextView cityNameTextView;
    private TextView weatherInfoTextView;
    private ImageView ivWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        cityNameTextView = findViewById(R.id.cityNameTextView);
        weatherInfoTextView = findViewById(R.id.weatherInfoTextView);
        ivWeather = findViewById(R.id.ivWeather);

        String cityName = getIntent().getStringExtra("cityName");

        cityNameTextView.setText(cityName);

        fetchWeatherData(cityName);
    }

    private void fetchWeatherData(String cityName) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.weatherapi.com/v1/current.json?key=8821a81d683b4cc5abb135527242912&q=" + cityName;

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(() ->
                        Toast.makeText(WeatherDetailsActivity.this, "Error!", Toast.LENGTH_SHORT).show()
                );
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String jsonResponse = response.body().string();
                    WeatherResponse weatherResponse = new Gson().fromJson(jsonResponse, WeatherResponse.class);

                    runOnUiThread(() -> updateUI(weatherResponse));
                }
            }
        });
    }

    private void updateUI(WeatherResponse weatherResponse) {
        String weatherInfo = "Temperature: " + weatherResponse.getTemperatureCelsius() + "°C\n" +
                "Feels like: " + weatherResponse.getFeelsLikeCelsius() + "°C\n" +
                "State: " + weatherResponse.getWeatherCondition()+
                "\nLocal time: "+weatherResponse.getLocalTime()+"\n"+
                "Wind: "+weatherResponse.getWindSpeedKph()+"Km/h";

        weatherInfoTextView.setText(weatherInfo);

        String iconUrl = "https:"+weatherResponse.getWeatherIcon();

        // ImageLoader
        ImageLoader imageLoader = new ImageLoader.Builder(this)
                .crossfade(true) // Включение плавного перехода
                .build();
        ImageRequest request = new ImageRequest.Builder(this)
                .data(iconUrl)
                .placeholder(R.drawable.placeholder)
                .target(ivWeather)
                .build();
        imageLoader.enqueue(request);
    }
}
