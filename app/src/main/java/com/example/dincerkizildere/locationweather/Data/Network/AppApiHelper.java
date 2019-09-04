package com.example.dincerkizildere.locationweather.Data.Network;

import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;
import com.example.dincerkizildere.locationweather.Data.Network.Service.ServiceCallback;
import com.example.dincerkizildere.locationweather.Data.Network.Service.WeatherCityNameService;

import javax.inject.Inject;

public class AppApiHelper implements ApiHelper {

    private WeatherCityNameService weatherCityNameService;

    @Inject
    public AppApiHelper(WeatherCityNameService weatherCityNameService) {
        this.weatherCityNameService = weatherCityNameService;
    }

    @Override
    public void weatherCityNameService(String cityName, ServiceCallback<WeatherResult> callBack) {
        weatherCityNameService.weatherCityNameService(cityName,callBack);

    }

    @Override
    public void weatherCityGpsService(String lat, String lng, ServiceCallback<WeatherResult> callBack) {
        weatherCityNameService.weatherCityGpsService(lat,lng,callBack);

    }
}