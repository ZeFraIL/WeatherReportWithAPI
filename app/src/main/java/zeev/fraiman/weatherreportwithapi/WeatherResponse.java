package zeev.fraiman.weatherreportwithapi;

public class WeatherResponse {
    private Location location;
    private Current current;

    // Метод для получения данных о местоположении
    public String getCityName() {
        return location.name;
    }

    public String getRegion() {
        return location.region;
    }

    public String getCountry() {
        return location.country;
    }

    public double getLatitude() {
        return location.lat;
    }

    public double getLongitude() {
        return location.lon;
    }

    public String getTimeZone() {
        return location.tz_id;
    }

    public String getLocalTime() {
        return location.localtime;
    }

    // Метод для получения текущей погоды
    public String getTemperatureCelsius() {
        return current.temp_c + "°C";
    }

    public String getTemperatureFahrenheit() {
        return current.temp_f + "°F";
    }

    public String getWeatherCondition() {
        return current.condition.text;
    }

    public String getWeatherIcon() {
        return current.condition.icon;
    }

    public double getWindSpeedMph() {
        return current.wind_mph;
    }

    public double getWindSpeedKph() {
        return current.wind_kph;
    }

    public int getWindDegree() {
        return current.wind_degree;
    }

    public String getWindDirection() {
        return current.wind_dir;
    }

    public double getPressureMb() {
        return current.pressure_mb;
    }

    public double getPressureIn() {
        return current.pressure_in;
    }

    public double getPrecipitationMm() {
        return current.precip_mm;
    }

    public double getPrecipitationIn() {
        return current.precip_in;
    }

    public int getHumidity() {
        return current.humidity;
    }

    public int getCloudCoverage() {
        return current.cloud;
    }

    public String getFeelsLikeCelsius() {
        return current.feelslike_c + "°C";
    }

    public String getFeelsLikeFahrenheit() {
        return current.feelslike_f + "°F";
    }

    public String getWindchillCelsius() {
        return current.windchill_c + "°C";
    }

    public String getWindchillFahrenheit() {
        return current.windchill_f + "°F";
    }

    public String getHeatIndexCelsius() {
        return current.heatindex_c + "°C";
    }

    public String getHeatIndexFahrenheit() {
        return current.heatindex_f + "°F";
    }

    public String getDewPointCelsius() {
        return current.dewpoint_c + "°C";
    }

    public String getDewPointFahrenheit() {
        return current.dewpoint_f + "°F";
    }

    public double getVisibilityKm() {
        return current.vis_km;
    }

    public double getVisibilityMiles() {
        return current.vis_miles;
    }

    public double getUvIndex() {
        return current.uv;
    }

    public double getGustSpeedMph() {
        return current.gust_mph;
    }

    public double getGustSpeedKph() {
        return current.gust_kph;
    }

    // Вложенные классы для Location и Current
    class Location {
        String name;
        String region;
        String country;
        double lat;
        double lon;
        String tz_id;
        String localtime;
    }

    class Current {
        String last_updated;
        double temp_c;
        double temp_f;
        int is_day;
        Condition condition;
        double wind_mph;
        double wind_kph;
        int wind_degree;
        String wind_dir;
        double pressure_mb;
        double pressure_in;
        double precip_mm;
        double precip_in;
        int humidity;
        int cloud;
        double feelslike_c;
        double feelslike_f;
        double windchill_c;
        double windchill_f;
        double heatindex_c;
        double heatindex_f;
        double dewpoint_c;
        double dewpoint_f;
        double vis_km;
        double vis_miles;
        double uv;
        double gust_mph;
        double gust_kph;

        class Condition {
            String text;
            String icon;
            int code;
        }
    }
}
