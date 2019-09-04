package com.example.dincerkizildere.locationweather.Ui.SettingsActivity;

import com.example.dincerkizildere.locationweather.Ui.Base.MvpPresenter;

public interface SettingsActivityMvpPresenter<V extends SettingsActivityMvpView> extends MvpPresenter<V> {
    void getCurrentLocation();
}
