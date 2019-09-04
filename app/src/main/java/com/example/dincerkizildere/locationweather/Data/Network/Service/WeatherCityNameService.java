package com.example.dincerkizildere.locationweather.Data.Network.Service;

import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;

public interface WeatherCityNameService {
    void weatherCityNameService(String cityName, ServiceCallback<WeatherResult> callBack);
    void weatherCityGpsService(String lat, String lng, ServiceCallback<WeatherResult> callBack);
}
