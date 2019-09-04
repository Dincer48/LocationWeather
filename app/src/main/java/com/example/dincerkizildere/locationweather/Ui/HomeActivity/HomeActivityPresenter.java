package com.example.dincerkizildere.locationweather.Ui.HomeActivity;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;

import com.example.dincerkizildere.locationweather.Data.DataManager;
import com.example.dincerkizildere.locationweather.Data.Network.Model.WeatherResult;
import com.example.dincerkizildere.locationweather.Data.Network.Service.ServiceCallback;
import com.example.dincerkizildere.locationweather.Ui.Base.BasePresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;

public class HomeActivityPresenter<V extends HomeActivityMvpView>extends BasePresenter<V> implements HomeActivityMvpPresenter<V> {

    Activity activity;
    private Context context;

    @Inject
    DataManager dataManager;


    public HomeActivityPresenter(Activity activity,Context context, DataManager dataManager) {
        super(activity);
        this.activity=activity;
        this.context=context;
        this.dataManager=dataManager;
    }

    @Override
    public void CreateBottomNavigatonView(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                getMvpView().loadBottomNavigationView(item);
                return true;
            }
        });

    }

    @Override
    public void getCityWeather(String cityName, String lan, String lng) {

        if (cityName != "Null"){
            dataManager.weatherCityNameService(cityName, new ServiceCallback<WeatherResult>() {
                @Override
                public void onResponse(WeatherResult response) {
                    getMvpView().loadWeather(response);
                }

                @Override
                public void onError(String message) {
                    getMvpView().showError(message);
                }
            });
        }

    }
}
