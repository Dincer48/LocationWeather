package com.example.dincerkizildere.locationweather.Data.Pref;

import java.util.List;
public interface PrefHelper {

    void saveGpsState(String state);
    String getGpsState();

    void saveCheckedCityCount(int checkedCount);
    int getCheckedCityCount();

    void saveCheckedCityList(List<String> cityList);
    List<String> getCheckedCityList();
}