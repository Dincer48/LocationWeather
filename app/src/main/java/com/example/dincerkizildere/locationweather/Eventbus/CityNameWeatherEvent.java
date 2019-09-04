package com.example.dincerkizildere.locationweather.Eventbus;

import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;

public class CityNameWeatherEvent {

    private WeatherResult weatherResult;

    public CityNameWeatherEvent(WeatherResult weatherResult){
        this.weatherResult=weatherResult;
    }

    public WeatherResult getWeatherResult(){
        return weatherResult;
    }

    public void setWeatherResult(WeatherResult weatherResult) {
        this.weatherResult = weatherResult;
    }
}
