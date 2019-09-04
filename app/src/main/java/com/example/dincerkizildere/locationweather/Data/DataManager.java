package com.example.dincerkizildere.locationweather.Data;

import com.example.dincerkizildere.locationweather.Data.Network.ApiHelper;
import com.example.dincerkizildere.locationweather.Data.Pref.PrefHelper;

public interface DataManager  extends ApiHelper, PrefHelper {
    int getChechkedCityCount();
}
