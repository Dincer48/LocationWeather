package com.example.dincerkizildere.locationweather.Data.Network.Service;

import com.example.dincerkizildere.locationweather.Data.Network.ApiClient;
import com.example.dincerkizildere.locationweather.Data.Network.ApiInterface;
import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;
import com.example.dincerkizildere.locationweather.Utility.Utils;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatherCityNameServiceImp implements WeatherCityNameService {

    private ApiInterface apiService;
    CompositeDisposable compositeDisposable;

    @Inject
    public WeatherCityNameServiceImp() {
        apiService = ApiClient.getClient().create(ApiInterface.class);
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void weatherCityNameService(String cityName, final ServiceCallback<WeatherResult> callBack) {

        apiService.weatherCityNameService(cityName,Utils.APP_ID, "metric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherResult weatherResult) {
                        callBack.onResponse(weatherResult);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void weatherCityGpsService(String lat, String lng, ServiceCallback<WeatherResult> callBack) {
        apiService.weatherCityGpsService(lat, lng, Utils.APP_ID, "metric")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherResult weatherResult) {
                        callBack.onResponse(weatherResult);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
