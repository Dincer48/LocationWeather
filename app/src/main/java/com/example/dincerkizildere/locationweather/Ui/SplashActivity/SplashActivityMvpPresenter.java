package com.example.dincerkizildere.locationweather.Ui.SplashActivity;

import com.example.dincerkizildere.locationweather.Ui.Base.MvpPresenter;

public interface SplashActivityMvpPresenter<V extends SplashActivityMvpView> extends MvpPresenter<V> {

    void startApplication();
}
