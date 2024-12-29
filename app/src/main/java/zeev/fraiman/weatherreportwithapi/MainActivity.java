package zeev.fraiman.weatherreportwithapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewCities;
    private List<String> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCities = findViewById(R.id.listViewCities);

        cityList = Arrays.asList("London", "New York", "Tokyo", "Moscow", "Paris");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityList);
        listViewCities.setAdapter(adapter);

        listViewCities.setOnItemClickListener((AdapterView<?> adapterView, android.view.View view, int position, long id) -> {
            String selectedCity = cityList.get(position); // Получаем выбранный город
            Intent intent = new Intent(MainActivity.this, WeatherDetailsActivity.class);
            intent.putExtra("cityName", selectedCity); // Передаем название города
            startActivity(intent);
        });
    }
}
