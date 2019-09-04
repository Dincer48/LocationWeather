package com.example.dincerkizildere.locationweather.Di;


import com.example.dincerkizildere.locationweather.Ui.Adapters.WeatherAdapter;
import com.example.dincerkizildere.locationweather.Ui.CitiesActivity.CitiesActivity;
import com.example.dincerkizildere.locationweather.Ui.HomeActivity.HomeActivity;
import com.example.dincerkizildere.locationweather.Ui.SettingsActivity.SettingsActivity;
import com.example.dincerkizildere.locationweather.Ui.SplashActivity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DaggerModule.class})
public interface DaggerComponent  {
    void inject(SplashActivity splashActivity);
    void inject(HomeActivity homeActivity);
    void inject(SettingsActivity settingsActivity);
    void inject(CitiesActivity citiesActivity);
    void inject(WeatherAdapter weatherAdapter);


}
