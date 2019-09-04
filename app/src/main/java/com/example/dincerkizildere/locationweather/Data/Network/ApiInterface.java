package com.example.dincerkizildere.locationweather.Data.Network;

import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("weather")
    Observable<WeatherResult> weatherCityNameService(@Query("q") String cityName,
                                                     @Query("appid") String appid,
                                                     @Query("units") String unıt);

    @GET("weather")
    Observable<WeatherResult> weatherCityGpsService(@Query("lat") String lat,
                                                    @Query("lon") String lon,
                                                    @Query("appid") String appid,
                                                    @Query("units") String unit);


}
